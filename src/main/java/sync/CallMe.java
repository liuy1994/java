package sync;

public class CallMe {
     void call(String str) {
        System.out.print("[" + str);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("interrupted");
        }
        System.out.println("]");
    }
}

