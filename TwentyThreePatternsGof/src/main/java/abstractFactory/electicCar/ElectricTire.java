package abstractFactory.electicCar;

import abstractFactory.Tire;

public class ElectricTire implements Tire {
    @Override
    public void produce() {
        System.out.println("Producing electric tires");
    }
}
