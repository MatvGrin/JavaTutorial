package factoryMethod;

public class Main {
    public static void main(String[] args) {
        FactoryOrder.create("online").process();
        FactoryOrder.create("store").process();
        FactoryOrder.create("mobile").process();
    }
}
