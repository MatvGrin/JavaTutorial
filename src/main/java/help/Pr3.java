package help;

public class Pr3 {
    public static void main(String[] args) {
        int i = 0;
        Counter counter = new Counter(i);
        counter.increment();
        System.out.println(i);


    }
}

class Counter{
    private int index;

    public Counter(int index) {
        this.index = index;
    }

    public void increment(){
        index++;
    }


}

