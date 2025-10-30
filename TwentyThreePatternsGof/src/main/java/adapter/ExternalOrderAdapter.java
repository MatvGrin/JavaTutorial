package adapter;

public class ExternalOrderAdapter implements OrderProcessor{
    private ExternalOrderProcessor processor;

    public ExternalOrderAdapter(ExternalOrderProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void process(String id) {
        processor.execute(id);
    }
}
