package abstractFactory.gasolineCar;

import abstractFactory.Engine;

public class GasolineEngine implements Engine {
    @Override
    public void produce() {
        System.out.println("Producing gasoline engine");
    }
}
