package car_ser.repo;

import car_ser.entity.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepoSql implements CarRepo{

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/car_ser?useSSL=true&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    {
        String sql = "CREATE TABLE IF NOT EXISTS cars(\n" +
                "id int auto_increment not null,\n" +
                "brand varchar(50) not null,\n" +
                "model varchar(50) not null,\n" +
                "year int not null,\n" +
                "color varchar(50) not null,\n" +
                "price int not null,\n" +
                "primary key(id)\n" +
                ")";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();) {
            boolean isExecute = statement.execute(sql);
            if (isExecute){
                System.out.println("Table Created Successfully");
            } else {
                System.out.println("Table Created UnSuccessfully");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Car> getAllCars() {
        String sql = "SELECT id, brand, model, year, color, price FROM cars";
        List<Car> cars = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                long year = resultSet.getLong("year");
                String color = resultSet.getString("color");
                long price = resultSet.getLong("price");
                Car car = new Car(id, brand, model, year, color, price);
                cars.add(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

    @Override
    public Car findCarById(long id) {
        String sql = "SELECT * FROM Cars WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                long year = resultSet.getLong("year");
                String color = resultSet.getString("color");
                long price = resultSet.getLong("price");
                return new Car(id, brand, model, year, color, price);
            } else {
                System.out.println("Car not found by id=" + id);
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean saveCar(Car car) {
        String sql = "INSERT INTO Cars (brand, model, year, color, price) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setString(1, car.getBrand());
            statement.setString(2, car.getModel());
            statement.setLong(3, car.getYear());
            statement.setString(4, car.getColor());
            statement.setLong(5, car.getPrice());

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows inserted: " + rowsAffected);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public boolean updateCar(Car car) {
        Car carById = findCarById(car.getId());
        if (carById == null) {
            return false;
        }
        String sql = "UPDATE Cars SET brand=?, model=?, year=?, color=?, price=? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, car.getBrand());
            statement.setString(2, car.getModel());
            statement.setLong(3, car.getYear());
            statement.setString(4, car.getColor());
            statement.setLong(5, car.getPrice());
            statement.setLong(6, car.getId());

            int rows = statement.executeUpdate();
            return rows == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeCar(Car car) {
        Car carById = findCarById(car.getId());
        if (carById == null) {
            return false;
        }
        String sql = "DELETE FROM Cars WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setLong(1, car.getId());
            int rows = statement.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
