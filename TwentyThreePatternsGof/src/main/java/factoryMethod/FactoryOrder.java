package factoryMethod;

public class FactoryOrder {
    public static Order create(String order){
        return switch (order) {
            case "online" -> new OnlineOrder();
            case "store" -> new InStoreOrder();
            case "mobile" -> new MobileOrder();
            default -> throw new IllegalArgumentException("Not such order");
        };
    }
}
