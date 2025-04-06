package car_ser;

import car_ser.service.CarService;
import car_ser.сonfig.CarConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
@Component
public class CarDemo {
    private CarService carService;
    @Autowired
    public CarDemo(CarService carService) {
        this.carService = carService;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CarConfig.class);
        CarDemo carDemo = context.getBean(CarDemo.class);
        carDemo.run();
    }

    public void run(){
        SwingUtilities.invokeLater(() -> new CarManager(carService).setVisible(true));
    }

}