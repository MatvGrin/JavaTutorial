package adapter;

public class MyOrderProcessor implements OrderProcessor{

    @Override
    public void process(String id) {
        System.out.println("I have processed order by id: " + id);
    }
}
