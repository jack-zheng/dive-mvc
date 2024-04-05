package org.dive.inject;

import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) throws Exception {
        Method aMethod = ClassA.class.getDeclaredMethod("method");
        System.out.println(ClassUtils.getMostSpecificMethod(aMethod, ClassB.class));

        Method bMethod = ClassB.class.getDeclaredMethod("method");
        System.out.println(ClassUtils.getMostSpecificMethod(bMethod, ClassB.class));
    }
}

class ClassA {
    public void method() {}
}

class ClassB extends ClassA {
    public void method() {}
}


