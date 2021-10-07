package com.company;

import com.company.Human;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello");

        Human human = new Human();
        
        System.out.println(human.name);
        System.out.println(human.weight);
        
        Human leon = new Human("leon", 200);
        System.out.println(leon.name);
        System.out.println(leon.weight);

        leon.rename("david");
        Human david = leon;
        int newWeight = david.workout();

        System.out.println(newWeight);

    }
}
