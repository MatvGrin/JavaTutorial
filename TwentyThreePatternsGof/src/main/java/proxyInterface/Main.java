package proxyInterface;

public class Main {
    public static void main(String[] args) {
        CheckSystem checkSystem = new CheckSystem();
//        Order order = new RealOrder();
        Order proxyOrder1 = new ProxyOrder("USER");
        Order proxyOrder2 = new ProxyOrder("ADMIN");

        checkSystem.check(proxyOrder1);
        System.out.println("----------------------");
        checkSystem.check(proxyOrder2);
    }
}
