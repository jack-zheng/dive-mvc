package org.dive.springaopapi.introductionsamples;

public class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}
