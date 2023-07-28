package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");


        System.out.println(map.get("key2"));
        map.remove("key2");
        map.remove("key2");
        System.out.println(map.get("key2"));

        map.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });
    }
}


