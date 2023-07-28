package com.company;

public class Human extends Animal {
    public Human(String name) {
        super(name);
    }

    public String say() {
        return name + ":human";
    }
}
