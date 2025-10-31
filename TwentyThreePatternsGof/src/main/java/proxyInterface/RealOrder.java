package proxyInterface;

public class RealOrder implements Order{

    @Override
    public void process() {
        System.out.println("We process real order.");
    }
}
