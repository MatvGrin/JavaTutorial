package decaratorSecond;

public class DiscountProduct extends Product{
    private Product product;

    public DiscountProduct(Product product) {
        this.product = product;
    }


    @Override
    public double getPrice() {
        double price = product.getPrice();
        double v = price - (price * 0.1);
        return v;
    }

    @Override
    public String getName() {
        return product.getName();
    }
}
