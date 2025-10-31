package adapterSecond;

public class Main {
    public static void main(String[] args) {
        ATS ats = new ATS();

        PaymentProcessor creditCard = new CreditCardProcessor();
        ats.handle(creditCard);

        LegacyPaymentSystem legacyPaymentSystem = new LegacyPaymentSystem();
        PaymentProcessorAdapter paymentProcessorAdapter = new PaymentProcessorAdapter(legacyPaymentSystem);
        ats.handle(paymentProcessorAdapter);
    }
}
