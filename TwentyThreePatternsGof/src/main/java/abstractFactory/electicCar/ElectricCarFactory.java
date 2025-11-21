package abstractFactory.electicCar;

import abstractFactory.CarFactory;
import abstractFactory.Engine;
import abstractFactory.Tire;

public class ElectricCarFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new ElectricEngine();
    }

    @Override
    public Tire createTire() {
        return new ElectricTire();
    }
}
