package singleton;

public class Main {
    public static void main(String[] args) {
        Counter counter1 = Counter.getInstance();
        Counter counter2 = Counter.getInstance();

        counter1.increment();
        counter1.increment();
        counter1.increment();
        counter1.increment();

        System.out.println("Count: " + counter1.getCount());

        counter2.increment();

        System.out.println("Count: " + counter2.getCount());
    }
}
