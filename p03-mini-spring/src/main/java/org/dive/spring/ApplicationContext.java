package org.dive.spring;

import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ApplicationContext {
    private final Map<String, BeanDefinition> definitionMap = new HashMap<>();
    private final Map<String, Object> beanMap = new HashMap<>();
    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    public ApplicationContext(Class<?> clazz) {
        // 解析配置类，扫描包，初始化 BeanDefinition
        ComponentScan annotation = clazz.getAnnotation(ComponentScan.class);
        String scanPath = annotation.value();
//        System.out.println("扫描路径：" + scanPath);
        // 扫描路径：org.dive
        scanPath = scanPath.replace(".", File.separator);
//        System.out.println("替换后的扫描路径：" + scanPath);

        // 扫描 @Component 修饰的类，初始化 BeanDefinition
        URL url = ApplicationContext.class.getClassLoader().getResource(scanPath);
//        System.out.println("URL：" + url);
        Objects.requireNonNull(url, "URL is null");

        // 这里简化了，将所有相关文件放到了 service 文件夹中，简化了扫描逻辑
        File targetDir = new File(url.getFile());
        File[] files = targetDir.listFiles();

        // 将所有 component 的类初始化为 BeanDefinition，放到 map 中
        for (File file : files) {
            String fileName = file.getName();
//            System.out.println("文件名：" + fileName);

            // file name is: /build/classes/java/main/org/dive/service
            // change it to dive.service
            String className = "org.dive.service." + fileName.replace(".class", "");
//            System.out.println("类名：" + className);

            try {
               Class<?> cls = Class.forName(className);
               if (cls.isAnnotationPresent(Component.class)) {
                   BeanDefinition beanDefinition = new BeanDefinition();
                   beanDefinition.setClazz(cls);
                   if (cls.isAnnotationPresent(Scope.class)
                           && "prototype".equals(cls.getAnnotation(Scope.class).value())) {
                          beanDefinition.setScope("prototype");
                   } else {
                       beanDefinition.setScope("singleton");
                   }

                   String componentName = cls.getAnnotation(Component.class).value();
                   if ("".equals(componentName)) {
                       componentName = Introspector.decapitalize(cls.getSimpleName());
//                       System.out.println("componentName: " + componentName);
                   }
                   definitionMap.put(componentName, beanDefinition);

                   // pre-init bbp bean
                   // 这段视频中是放在前面 component 的 if 之后，不知道是不是抄的源码
                   // 效果上来说，放在这里也是可以的
                   if (BeanPostProcessor.class.isAssignableFrom(cls)) {
                       beanPostProcessors.add((BeanPostProcessor) createBean(componentName, beanDefinition));
                   }
               }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

//        System.out.println("definitionMap: " + definitionMap);
        // create all singleton beans
        for (Map.Entry<String, BeanDefinition> entry : definitionMap.entrySet()) {
            if ("singleton".equals(entry.getValue().getScope())) {
                beanMap.put(entry.getKey(), createBean(entry.getKey(), entry.getValue()));
            }
        }

//        System.out.println("beanMap: " + beanMap);
    }

    public Object getBean(String beanName) {
        // 为什么不先从 beanMap 拿呢？快啊
        // 但是从 bean definition 出发貌似更可靠一点
        BeanDefinition beanDefinition = definitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new NullPointerException("No such bean definition");
        } else {
            if ("singleton".equals(beanDefinition.getScope())) {
                // get from bean map;
                Object bean = beanMap.get(beanName);
                if (bean == null) {
                    bean = createBean(beanName, beanDefinition);
                    beanMap.put(beanName, bean);
                    return bean;
                }
                return bean;
            } else {
                // create new instance
                return createBean(beanName, beanDefinition);
            }
        }
    }

    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        try {
            Object bean = beanDefinition.getClazz().getDeclaredConstructor().newInstance();
            // check if there is any dependency, if so, inject it
            Field[] fields = beanDefinition.getClazz().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    field.setAccessible(true);
                    field.set(bean, getBean(field.getName()));
                }
            }

            // process aware interface
            if (bean instanceof BeanNameAware) {
                ((BeanNameAware) bean).setBeanName(beanName);
            }

            // BeanPostProcessor::before
            for (BeanPostProcessor bpp : beanPostProcessors) {
                bean = bpp.postProcessBeforeInitialization(bean, beanName);
            }

            // process InitializingBean interface
            if (bean instanceof InitializingBean) {
                ((InitializingBean) bean).afterPropertiesSet();
            }

            // BeanPostProcessor::after
            for (BeanPostProcessor bpp : beanPostProcessors) {
                bean = bpp.postProcessAfterInitialization(bean, beanName);
            }

            return bean;
        } catch (InstantiationException
                 | IllegalAccessException
                 | InvocationTargetException
                 | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
