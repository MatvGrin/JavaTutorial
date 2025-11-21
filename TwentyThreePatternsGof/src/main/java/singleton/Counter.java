package singleton;

public class Counter {
    private static Counter COUNTER;
    private static int count = 0;
    private Counter(){}

    void increment(){
        count++;
    }
    int getCount(){
        return count;
    }

    public static Counter getInstance(){
        if (COUNTER == null){
            synchronized (Counter.class){
                COUNTER = new Counter();
            }
        }
        return COUNTER;
    }
}
