package com.company.animal;

public abstract class Animal {
    private final String name;
    public Animal(String name) {
        this.name = name;
    }
    public abstract void say();

    public String getName() {
        return name;
    }


}
