package org.dive.inject;

import java.lang.reflect.Field;

public class TestReflection {
    public static void main(String[] args) {
        for (Field declaredField : Child.class.getDeclaredFields()) {
            System.out.println("field: " + declaredField);
        }

        System.out.println("====================================");

        for (Field field : Child.class.getFields()) {
            System.out.println("field: " + field);
        }
    }
}
