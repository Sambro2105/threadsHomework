package FirstHomeworkWIP;

public class Main {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread(1);
        MyThread myThread2 = new MyThread(5);
        MyTimer timer = new MyTimer();

        timer.assignThread(myThread1);
        timer.assignThread(myThread2);

        myThread1.start();
        myThread2.start();
        timer.start();
    }
}