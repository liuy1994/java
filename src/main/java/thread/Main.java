package thread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new ThreadLower();
        new ThreadUpper();
        for (int i = 0; i < 100; i++) {
            Thread.sleep(10);
            System.out.println("Main Thread: i = " + i);
        }
    }
}
