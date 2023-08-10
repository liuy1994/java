package spring.user;

public class Calc {
    private int a;

    public Calc(int a) {
        this.a = a;
    }

    public int add(int b) {
        return a + b;
    }

    public int sum(int a, int b) {
        return a + b;
    }
}
