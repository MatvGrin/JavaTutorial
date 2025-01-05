package car_ser;

import car_ser.entity.Car;
import car_ser.repo.CarRepoSql;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CarManager extends JFrame {

    private CarRepoSql carRepoSql;

    public CarManager() {
        setTitle("Car Manager");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        carRepoSql = new CarRepoSql();

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));

        JButton addButton = new JButton("Save Car");
        JButton updateButton = new JButton("Update Car");
        JButton deleteButton = new JButton("Delete Car");
        JButton findButton = new JButton("Find Car by ID");
        JButton listButton = new JButton("Get All Cars");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(findButton);
        buttonPanel.add(listButton);

        add(buttonPanel);

        addButton.addActionListener(e -> addCar());
        updateButton.addActionListener(e -> updateCar());
        deleteButton.addActionListener(e -> deleteCar());
        findButton.addActionListener(e -> findCar());
        listButton.addActionListener(e -> showAllCars());
    }
    private void addCar() {
        try {
            String brand = JOptionPane.showInputDialog(this, "Enter brand:");
            String model = JOptionPane.showInputDialog(this, "Enter model:");
            long year = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter year:"));
            String color = JOptionPane.showInputDialog(this, "Enter color:");
            long price = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter price:"));

            if (brand == null || model == null || color == null) {
                JOptionPane.showMessageDialog(this, "canceled");
                return;
            }

            Car car = new Car(0, brand, model, year, color, price);
            carRepoSql.saveCar(car);
            JOptionPane.showMessageDialog(this, "Car added!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error");
        }
    }

    private void updateCar() {
        try {
            long id = Long.parseLong(JOptionPane.showInputDialog(this, "Enter car ID to update:"));
            Car car = carRepoSql.findCarById(id);

            if (car == null) {
                JOptionPane.showMessageDialog(this, "not found");
                return;
            }
            String brand = JOptionPane.showInputDialog(this, "Enter new brand:", car.getBrand());
            String model = JOptionPane.showInputDialog(this, "Enter new model:", car.getModel());
            long year = Long.parseLong(JOptionPane.showInputDialog(this, "Enter new year:", car.getYear()));
            String color = JOptionPane.showInputDialog(this, "Enter new color:", car.getColor());
            long price = Long.parseLong(JOptionPane.showInputDialog(this, "Enter new price:", car.getPrice()));
            car.setBrand(brand);
            car.setModel(model);
            car.setYear(year);
            car.setColor(color);
            car.setPrice(price);

            carRepoSql.updateCar(car);
            JOptionPane.showMessageDialog(this, "Car updated");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error");
        }
    }

    private void deleteCar() {
        try {
            long id = Long.parseLong(JOptionPane.showInputDialog(this, "Enter car ID:"));
            Car car = carRepoSql.findCarById(id);

            if (car == null) {
                JOptionPane.showMessageDialog(this, "not found");
                return;
            }
            carRepoSql.removeCar(car);
            JOptionPane.showMessageDialog(this, "Car deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error");
        }
    }

    private void findCar() {
        try {
            long id = Long.parseLong(JOptionPane.showInputDialog(this, "Enter car ID:"));
            Car car = carRepoSql.findCarById(id);
            JOptionPane.showMessageDialog(this, "Car found:\n" + car.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error");
        }
    }

    private void showAllCars() {
        List<Car> cars = carRepoSql.getAllCars();
        if (cars.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No cars in the database.");
        } else {
            StringBuilder carList = new StringBuilder("All Cars:\n");
            for (Car car : cars) {
                carList.append(car.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(this, carList.toString());
        }
    }
}
