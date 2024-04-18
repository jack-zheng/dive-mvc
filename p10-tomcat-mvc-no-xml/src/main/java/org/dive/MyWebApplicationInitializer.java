package org.dive;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) {
        System.out.println("Call MyWebApplicationInitializer::onStartup()...");
        //通过注解的方式初始化Spring的上下文
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();

        //注册spring的配置类（替代传统项目中xml的configuration）
        ac.register(AppConfig.class);

        //基于java代码的方式初始化DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(ac);
        //绑定servlet
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);

        //设置tomcat启动立即加载 servlet
        registration.setLoadOnStartup(1);
        //浏览器访问uri
        registration.addMapping("/*");
    }
}
