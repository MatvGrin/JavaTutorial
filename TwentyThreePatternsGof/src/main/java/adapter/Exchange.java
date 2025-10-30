package adapter;

public class Exchange {
    public void handle(OrderProcessor orderProcessor){
        orderProcessor.process("25");
    }
}
