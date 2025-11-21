package abstractFactory.gasolineCar;

import abstractFactory.CarFactory;
import abstractFactory.Engine;
import abstractFactory.Tire;

public class GasolineCarFactory implements CarFactory {

    @Override
    public Engine createEngine() {
        return new GasolineEngine();
    }

    @Override
    public Tire createTire() {
        return new GasolineTire();
    }
}
