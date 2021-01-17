package SecondTask;

public class Shipper implements Runnable {

    Storage storage;

    Shipper(Storage storage) {
        this.storage = storage;
    }

    public void run() {
        try {
            while (true) {
                storage.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
