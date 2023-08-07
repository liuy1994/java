package sync;

public class Caller implements Runnable {
    String msg;
    final CallMe callMe;
    Thread t;

    public Caller(CallMe target, String msg) {
        this.callMe = target;
        this.msg = msg;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        synchronized (callMe) {
            callMe.call(msg);
        }
    }
}
