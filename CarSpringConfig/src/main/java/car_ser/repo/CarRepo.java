package car_ser.repo;

import car_ser.entity.Car;

import java.util.List;

public interface CarRepo {

    List<Car> getAllCars();
    Car findCarById(long id);
    boolean saveCar(Car car);
    boolean updateCar(Car car);
    boolean removeCar(Car car);
}
