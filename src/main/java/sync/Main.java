package sync;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        CallMe callMe = new CallMe();
        Caller caller = new Caller(callMe, "Hello");
        Caller caller2 = new Caller(callMe, "World");
        Caller caller3 = new Caller(callMe, "!");

        try {
            caller.t.join();
            caller2.t.join();
            caller3.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("interrupted");
        }
    }
}

