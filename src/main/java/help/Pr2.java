package help;

public class Pr2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new NumberPrinter());
        thread1.start();
        Thread thread2 = new Thread(new NumberPrinter());
        thread2.start();
        Thread thread3 = new Thread(new NumberPrinter());
        thread3.setPriority(8);
        thread3.start();
    }
}

class NumberPrinter implements Runnable{

    @Override
    public void run() {
        System.out.println("Start");
        Thread thread = Thread.currentThread();
        for (int i = 1; i < 1001; i++) {
            System.out.println(thread.getName()+ ": " + i);
        }
        System.out.println("End");
    }

}
