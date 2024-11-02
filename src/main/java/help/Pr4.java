package help;

public class Pr4 {
    public static void main(String[] args) {
        Store store = new Store();
        FoodConsumer consumer = new FoodConsumer(store);
        FoodProducer producer = new FoodProducer(store);
        consumer.start();
        producer.start();
    }
}

class Store {
    int food = 0;

    public synchronized void producer(){
        while (food >= 3){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Producer producer food");
        food++;
        System.out.println("Store has: " + food);
        notify();
    }
    public synchronized void consumer(){
        while (food <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumer consume food");
        food--;
        System.out.println("Store has: " + food);
        notify();
    }

}

class FoodProducer extends Thread{
    private final Store store;

    public FoodProducer(Store store) {
        this.store = store;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            store.producer();
        }
    }
}

class FoodConsumer extends Thread{
    private final Store store;

    public FoodConsumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            store.consumer();
        }
    }
}