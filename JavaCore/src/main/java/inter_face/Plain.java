package inter_face;

public class Plain implements Flyable, Eatable {

    @Override
    public void fly() {
        System.out.println("Plain is flying");
    }

    @Override
    public void eat() {
        System.out.println("Plain eats fuel");
    }
}
