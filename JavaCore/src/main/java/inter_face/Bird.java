package inter_face;

public class Bird implements Flyable, Eatable {

    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }

    @Override
    public void eat() {
        System.out.println("Bird eats hot-dog");
    }
}
