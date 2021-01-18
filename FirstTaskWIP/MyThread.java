package FirstTaskWIP;

import java.time.Instant;

class MyThread extends Thread {
    private Instant lastCallDate;
    private final int periodInSeconds;

    public MyThread(int periodInSeconds) {
        this.lastCallDate = Instant.now();
        this.periodInSeconds = periodInSeconds;
    }

    public synchronized void wake(Instant time) {
        if (lastCallDate.plusSeconds(this.periodInSeconds).isBefore(time)) {
            System.out.println(this.getName() + " --- " + time);
            this.lastCallDate = time;
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}