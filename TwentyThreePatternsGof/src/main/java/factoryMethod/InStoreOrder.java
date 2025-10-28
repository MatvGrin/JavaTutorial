package factoryMethod;

public class InStoreOrder implements Order{
    @Override
    public void process() {
        System.out.println("I wanna order in Store some products.");
    }
}
