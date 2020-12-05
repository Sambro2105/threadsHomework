import java.time.Instant;

class MyTimer extends Thread {
    private final Control control;

    public MyTimer(Control control) {
        this.control = control;
    }

    @Override
    public void run() {
        while (true) {
            control.setDate(Instant.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}