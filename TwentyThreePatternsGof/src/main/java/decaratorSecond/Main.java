package decaratorSecond;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Product product1 = new Product("Milk", 2.5);
        Product product2 = new Product("Apple", 0.83);
        Product product3 = new Product("Nuts", 4.3);
        DiscountProduct discountProduct1 = new DiscountProduct(product1);
        DiscountProduct discountProduct2 = new DiscountProduct(product2);
        DiscountProduct discountProduct3 = new DiscountProduct(product3);
        shop.sell(discountProduct1);
        shop.sell(discountProduct2);
        shop.sell(discountProduct3);


    }
}
