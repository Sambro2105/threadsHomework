package FirstTask;

import java.time.Instant;

public class Control {
    private Instant date;

    public Control() {
        this.date = Instant.now();
    }

    public synchronized void setDate(Instant date) {
        this.date = date;
        notifyAll();
    }

    public synchronized Instant getDate() throws InterruptedException {
        wait();
        return date;
    }
}