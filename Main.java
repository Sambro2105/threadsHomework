public class Main {
    public static void main(String[] args) {
        final Control control = new Control();

        MyThread myThread1 = new MyThread(1, control);
        MyThread myThread2 = new MyThread(5, control);
        MyTimer timer = new MyTimer(control);

        myThread1.start();
        myThread2.start();
        timer.start();
    }
}