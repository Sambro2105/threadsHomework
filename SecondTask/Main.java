package SecondTask;

public class Main {
    public static void main(String[] args) {

        Storage storage = new Storage();
        Provider provider = new Provider(storage);
        Shipper shipper = new Shipper(storage);
        new Thread(provider).start();
        new Thread(shipper).start();
    }
}
