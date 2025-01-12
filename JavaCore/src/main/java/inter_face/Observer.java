package inter_face;

public class Observer {

    public void ObserveFlying(Flyable flyable) {
        System.out.println("...");
        flyable.fly();
    }

}
