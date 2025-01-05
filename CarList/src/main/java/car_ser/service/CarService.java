package car_ser.service;

import car_ser.entity.Car;

import java.util.List;

public interface CarService{
    List<Car> showAllCars();
    Car findCarById(int id);
    boolean saveCar(Car car);
    boolean updateCar(Car car);
    boolean removeCar(Car car);
}
