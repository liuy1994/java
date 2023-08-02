package thread;

public class ThreadLower extends Thread  {
    public ThreadLower() {
        super("lower thread");
        System.out.println("Lower Thread: " + this);
        start();
    }

    @Override
    public void run() {
        for (char i = 'a'; i <= 'z'; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Lower Thread: i = " + i);
        }
    }
}
