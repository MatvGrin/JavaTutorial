package car_ser.service;

import car_ser.entity.Car;
import car_ser.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarServiceImpl implements CarService{

    private final CarRepo carRepo;

    @Autowired
    public CarServiceImpl(@Qualifier("carRepoJdbcSpring")CarRepo carRepo) {
        this.carRepo=carRepo;
    }

    @Override
    public List<Car> showAllCars() {
        return carRepo.getAllCars();
    }

    @Override
    public Car findCarById(long id) {
        return carRepo.findCarById(id);
    }

    @Override
    public boolean saveCar(Car car) {
        return carRepo.saveCar(car);
    }

    @Override
    public boolean updateCar(Car car) {
        return carRepo.updateCar(car);
    }

    @Override
    public boolean removeCar(Car car) {
        return carRepo.removeCar(car);
    }
}
