package org.dive.inherit;

public class Parent {
    private int count = 0;
//    public Parent() {
//        count = 1;
//        System.out.println("in parent...");
//    }

    public Parent(int count) {
        count = 2;
        System.out.println("in parent 2...");
    }
}
