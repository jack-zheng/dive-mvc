package org.dive.inherit;

public class Child extends Parent{
    private String name = "John";

    public Child() {
        super(2);
        this.name = "Jack";
        System.out.println("in child...");
    }
}
