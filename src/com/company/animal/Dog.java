package com.company.animal;

public class Dog extends Animal{
    public Dog(String name){
        super(name);
    }

    @Override
    public void say(){
        System.out.println(getName() + ": 汪汪汪");
    }
}
