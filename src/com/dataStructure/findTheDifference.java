package com.dataStructure;

import java.util.HashMap;

public class findTheDifference {
    public static void main(String[] args) {
        solve("abd", "abds");
    }
    public static char solve(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] listS = s.toCharArray();
        char[] listT = t.toCharArray();
        for (char strS:listS) {
            if (!map.containsKey(strS)) {
                map.put(strS, 1);
            } else {
                map.put(strS, map.get(strS) + 1);
            }
        }
        for (char strT:listT) {
            if (map.containsKey(strT) && map.get(strT) > 0) {
                map.put(strT, map.get(strT) - 1);
            } else if (map.containsKey(strT) && map.get(strT) == 0) {
                return strT;
            } else {
                return strT;
            }
        }
        return 0;
    }
}
