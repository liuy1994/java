package com.company;

public class Human {
    private final String name;
    private int height;

    public Human(String name) {
        this.name = name;
        this.height = 200;
    }
    public Human(String name, int height) {
        this.name = name;
        this.height = height;
    }
    public String getName() {
        return this.name;
    }
}
