package car_ser;

import car_ser.entity.Car;
import car_ser.repo.CarRepo;
import car_ser.repo.CarRepoSql;
import car_ser.service.CarService;
import car_ser.service.CarServiceImpl;

import javax.swing.*;

public class CarDemo extends CarManager {


    public CarDemo(CarService carService) {
        super(carService);
    }

    public static void main(String[] args) {
        CarRepo carRepo = new CarRepoSql();
        CarService carService = new CarServiceImpl(carRepo);

//        carService.saveCar(new Car(1, "Toyota", "Corolla", 2022, "Red", 22000));
//        carService.saveCar(new Car(2, "Honda", "Civic", 2021, "Blue", 21000));
//        carService.saveCar(new Car(3, "Ford", "Focus", 2020, "Black", 18000));
//        carService.saveCar(new Car(4, "BMW", "X5", 2023, "White", 50000));
//        carService.saveCar(new Car(5, "Audi", "A4", 2022, "Silver", 35000));
//        carService.saveCar(new Car(6, "Mercedes", "C-Class", 2021, "Gray", 40000));
//        carService.saveCar(new Car(7, "Tesla", "Model 3", 2023, "Blue", 55000));
//        carService.saveCar(new Car(8, "Chevrolet", "Malibu", 2019, "Yellow", 15000));
//        carService.saveCar(new Car(9, "Hyundai", "Elantra", 2021, "Green", 19000));
//        carService.saveCar(new Car(10, "Nissan", "Altima", 2020, "Orange", 22000));

        SwingUtilities.invokeLater(() -> new CarManager(carService).setVisible(true));
//        for (Car car : carService.showAllCars()) {
//            System.out.println(car);
//        }
//        System.out.println("----------------------------------");
//        System.out.println(carService.findCarById(5));
//        System.out.println("----------------------------------");
//        System.out.println(carService.removeCar(car9));
//        System.out.println("----------------------------------");
//        System.out.println(new Car(7, "ABC", "Model 5", 2000, "Blue", 100));
    }

}
