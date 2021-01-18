package FirstTaskWIP;

import java.time.Instant;
import java.util.ArrayList;

class MyTimer extends Thread {
    private ArrayList<MyThread> threads = new ArrayList<>();

    public void assignThread(MyThread thread) {
        this.threads.add(thread);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                for (MyThread thread: threads) {
                    thread.wake(Instant.now());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}