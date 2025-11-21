package abstractFactory.gasolineCar;

import abstractFactory.Tire;

public class GasolineTire implements Tire {
    @Override
    public void produce() {
        System.out.println("Producing gasoline tires");
    }
}
