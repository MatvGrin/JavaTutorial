package factoryMethod;

public class MobileOrder implements Order{
    @Override
    public void process() {
        System.out.println("I wanna order in Mobile Store some products.");
    }
}
