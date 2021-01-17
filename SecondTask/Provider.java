package SecondTask;

public class Provider implements Runnable {

    Storage storage;

    Provider(Storage storage) {
        this.storage = storage;
    }

    public void run() {
        try {
            while (true) {
                storage.put();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
