package adapter;

public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new MyOrderProcessor();
        Exchange exchange = new Exchange();
        exchange.handle(orderProcessor);

        ExternalOrderProcessor externalOrderProcessor = new ExternalOrderProcessor();
        ExternalOrderAdapter externalOrderAdapter = new ExternalOrderAdapter(externalOrderProcessor);
        exchange.handle(externalOrderAdapter);
    }
}
