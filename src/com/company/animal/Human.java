package com.company.animal;

public class Human extends Animal {
    public Human(String name) {
        super(name);
    }

    @Override
    public void say() {
        System.out.println(getName() + ": hello");
    }

}
