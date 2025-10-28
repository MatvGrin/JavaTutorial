package factoryMethod;

public class OnlineOrder implements Order{
    @Override
    public void process() {
        System.out.println("I wanna order in Online Store some products.");
    }
}
