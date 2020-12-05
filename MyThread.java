import java.time.Instant;

class MyThread extends Thread {
    private Instant lastCallDate;
    private final int periodInSeconds;
    private final Control control;

    public MyThread(int periodInSeconds, Control control) {
        this.lastCallDate = Instant.now();
        this.periodInSeconds = periodInSeconds;
        this.control = control;
    }

    @Override
    public void run() {
        while (true) {
            if (lastCallDate.plusSeconds(this.periodInSeconds).isBefore(this.control.getDate())) {
                System.out.println(this.getName() + " --- " + this.control.getDate());
                this.lastCallDate = this.control.getDate();
            }
        }
    }
}