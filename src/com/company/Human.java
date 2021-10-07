package com.company;

public class Human {
    // 成员变量
    public String name;
    public int weight;
    static int number = 0;

    public Human() {
        this.weight = 100;
        this.name = "name";
    }

    public Human(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public void rename(String newName) {
        this.name = newName;
    }

    public int workout() {
        this.weight = this.weight - 5;
        return this.weight;
    }
}
