package car_ser;

import car_ser.service.CarService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

public class CarDemo {
    private CarService carService;
    public CarDemo(CarService carService) {
        this.carService = carService;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        CarDemo carDemo = context.getBean("carDemo", CarDemo.class);
        carDemo.run();
    }

    public void run(){
        SwingUtilities.invokeLater(() -> new CarManager(carService).setVisible(true));
    }

}
