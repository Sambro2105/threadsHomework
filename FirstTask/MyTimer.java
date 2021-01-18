package FirstTask;

import java.time.Instant;

class MyTimer extends Thread {
    private Control control;

    public MyTimer(Control control) {
        this.control = control;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException ignored) {
            }
            control.setDate(Instant.now());
        }
    }
}