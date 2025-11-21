package abstractFactory;

import abstractFactory.electicCar.ElectricCarFactory;
import abstractFactory.gasolineCar.GasolineCarFactory;

public class Main {
    public static void main(String[] args) {
        ElectricCarFactory electricCarFactory = new ElectricCarFactory();

        Engine engine = electricCarFactory.createEngine();
        engine.produce();

        Tire tire = electricCarFactory.createTire();
        tire.produce();

        GasolineCarFactory gasolineCarFactory = new GasolineCarFactory();

        Engine engine1 = gasolineCarFactory.createEngine();
        engine1.produce();

        Tire tire1 = gasolineCarFactory.createTire();
        tire1.produce();


    }
}
