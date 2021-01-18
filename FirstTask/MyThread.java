package FirstTask;

import java.time.Instant;

class MyThread extends Thread {
    private final int periodInSeconds;
    private Instant lastCallTime;
    private final Control control;

    public MyThread(int periodInSeconds, Control control) {
        this.lastCallTime = Instant.now();
        this.periodInSeconds = periodInSeconds;
        this.control = control;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Instant now = control.getDate();
                if (this.lastCallTime.plusSeconds(this.periodInSeconds).isBefore(now)) {
                    this.lastCallTime = now;
                    System.out.println(this.getName() + " --- " + now.toString()
                            .replace("T", " ").replace("Z", ""));
                }
            } catch (InterruptedException ignored) {
            }
        }
    }
}