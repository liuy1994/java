package com.dataStructure;

import java.util.Stack;

public class HanoiTower {
    private Stack<Integer> disks;
    /*
     * @param i: An integer from 0 to 2
     */
    public HanoiTower(int i) {
        // create three towers
        disks = new Stack();
    }
    public static void main(String[] args) {
//        solve("abd", "abds");
    }
    /*
     * @param d: An integer
     * @return: nothing
     */
    public void add(int d) {
        // Add a disk into this tower
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    /*
     * @param t: a tower
     * @return: nothing
     */
    public void moveTopTo(HanoiTower t) {
        // Move the top disk of this tower to the top of t.
        if(!disks.isEmpty()) {
            int plat = disks.pop();
            t.add(plat);
        }
    }

    /*
     * @param n: An integer
     * @param destination: a tower
     * @param buffer: a tower
     * @return: nothing
     */
    public void moveDisks(int n, HanoiTower destination, HanoiTower buffer) {
        // Move n Disks from this tower to destination by buffer tower
        if (n != 0) {
            moveDisks(n - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }

    /*
     * @return: Disks
     */
    public Stack<Integer> getDisks() {
        // write your code here
        return disks;
    }
}

/**
 * Your HanoiTower object will be instantiated and called as such:
 * HanoiTower[] towers = new HanoiTower[3];
 * for (int i = 0; i < 3; i++) towers[i] = new HanoiTower(i);
 * for (int i = n - 1; i >= 0; i--) towers[0].add(i);
 * towers[0].moveDisks(n, towers[2], towers[1]);
 * print towers[0], towers[1], towers[2]
 */
