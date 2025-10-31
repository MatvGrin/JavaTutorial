package adapterSecond;

public class PaymentProcessorAdapter implements PaymentProcessor{
    private LegacyPaymentSystem process;

    public PaymentProcessorAdapter(LegacyPaymentSystem process) {
        this.process = process;
    }

    @Override
    public void pay(double amount) {
        process.makeTransaction((int) (amount*100));
    }
}
