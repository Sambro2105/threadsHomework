package FirstHomeworkWIP;

import java.time.Instant;

class Control {
    private volatile Instant date;

    public Control() {
        this.date = Instant.now();
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Instant getDate() {
        return date;
    }
}