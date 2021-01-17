package SecondTask;

public class Storage {
    private int products = 0;

    public synchronized void get() {
        while (products < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        products--;
        System.out.println("Отгружен 1 товар");
        System.out.println("Товаров на складе: " + products);
        notify();
    }

    public synchronized void put() {
        while (!(products < 5)) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        products++;
        System.out.println("Поставщик привез 1 товар");
        System.out.println("Товаров на складе: " + products);
        notify();
    }
}
