package adapterSecond;

public class CreditCardProcessor implements PaymentProcessor{

    @Override
    public void pay(double amount) {
        System.out.println("You paid " + amount + " dollars.");
    }
}
