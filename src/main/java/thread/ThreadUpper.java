package thread;

public class ThreadUpper extends Thread {
    public ThreadUpper() {
        super("upper thread");
        System.out.println("Upper Thread: " + this);
        start();
    }

    @Override
    public void run() {
        for (char i = 'A'; i <= 'Z'; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Upper Thread: i = " + i);
        }
    }
}
