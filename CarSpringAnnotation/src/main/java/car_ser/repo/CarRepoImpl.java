package car_ser.repo;

import car_ser.entity.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CarRepoImpl implements CarRepo{

    private final Map<Long, Car> cars = new HashMap<>();

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(cars.values());
    }

    @Override
    public Car findCarById(long id) {
        return cars.get(id);
    }

    @Override
    public boolean saveCar(Car car) {
        Car carFromMap = cars.get(car.getId());
        if(carFromMap != null) {
            return false;
        }
        cars.put(car.getId(), car);
        return true;
    }

    @Override
    public boolean updateCar(Car car) {
        Car carFromMap = cars.get(car.getId());
        if(carFromMap == null) {
            return false;
        }
        cars.put(car.getId(), car);
        return true;
    }

    @Override
    public boolean removeCar(Car car) {
        Car carFromMap = cars.get(car.getId());
        if(carFromMap == null) {
            return false;
        }
        cars.remove(car.getId(), car);
        return true;
    }
}
