package abstractFactory.electicCar;

import abstractFactory.Engine;

public class ElectricEngine implements Engine {
    @Override
    public void produce() {
        System.out.println("Producing electric engine");
    }
}
