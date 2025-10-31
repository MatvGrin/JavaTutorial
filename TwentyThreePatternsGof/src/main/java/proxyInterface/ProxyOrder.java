package proxyInterface;

public class ProxyOrder implements Order{
    private RealOrder realOrder;
    private final String role;

    public ProxyOrder(String role) {
        this.role = role;
    }

    @Override
    public void process() {
        if (role.equalsIgnoreCase("ADMIN")){
            if (realOrder == null) realOrder = new RealOrder();
            System.out.println("Permission successfully passed");
            realOrder.process();
            System.out.println("Order processed");
        }else {
            System.out.println("Access denied.");
        }
    }
}
