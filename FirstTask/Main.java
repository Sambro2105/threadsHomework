package FirstTask;

public class Main {
    public static void main(String[] args) {
        Control control = new Control();

        MyThread myThread0 = new MyThread(1, control);
        MyThread myThread1 = new MyThread(5, control);
        MyTimer timer = new MyTimer(control);

        timer.start();
        myThread0.start();
        myThread1.start();
    }
}