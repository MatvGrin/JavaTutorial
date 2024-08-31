package inter_face;

public class Main {
    public static void main(String[] args) {
        Flyable bird = new Bird();
        Flyable plain = new Plain();

        Observer observer1 = new Observer();

        observer1.ObserveFlying(bird);
        observer1.ObserveFlying(plain);
    }
}
