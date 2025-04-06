package car_ser.repo;


import car_ser.entity.Car;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarRepoJdbcSpring implements CarRepo{

    private final JdbcTemplate jdbcTemplate;

    public CarRepoJdbcSpring(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Car> getAllCars() {
        String sql = "SELECT id, brand, model, year, color, price FROM cars";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Car(
                rs.getLong("id"),
                rs.getString("brand"),
                rs.getString("model"),
                rs.getInt("year"),
                rs.getString("color"),
                rs.getInt("price")
        ));
    }

    @Override
    public Car findCarById(long id) {
        String sql = "SELECT * FROM cars WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Car(
                rs.getLong("id"),
                rs.getString("brand"),
                rs.getString("model"),
                rs.getInt("year"),
                rs.getString("color"),
                rs.getInt("price")), id);
    }

    @Override
    public boolean saveCar(Car car) {
        String sql = "INSERT INTO cars (brand, model, year, color, price) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, car.getBrand(), car.getModel(), car.getYear(), car.getColor(), car.getPrice()) > 0;
    }

    @Override
    public boolean updateCar(Car car) {
        String sql = "UPDATE cars SET brand=?, model=?, year=?, color=?, price=? WHERE id=?";
        return jdbcTemplate.update(sql, car.getBrand(), car.getModel(), car.getYear(), car.getColor(), car.getPrice(), car.getId()) > 0;
    }

    @Override
    public boolean removeCar(Car car) {
        String sql = "DELETE FROM cars WHERE id=?";
        return jdbcTemplate.update(sql, car.getId()) > 0;
    }
}
