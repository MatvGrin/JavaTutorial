package help;

public class Pr1 {
    public static void main(String[] args) {

        Thread thread = new Thread(new MersProducer());
        thread.start();
    }
}
abstract class AbstractCarProducer{
    abstract void creativeNewCar();

}
class MersProducer extends AbstractCarProducer implements Runnable{

    @Override
    void creativeNewCar() {
        System.out.println("Creat New Car");
    }

    @Override
    public void run() {
        System.out.println("Start");
        creativeNewCar();
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        System.out.println("End");
    }
}