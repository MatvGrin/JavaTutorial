package university_management.repo;

import university_management.config.DatabaseConnection;
import university_management.entity.Students;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepoSql implements StudentRepo{

    {
        String sql = "CREATE TABLE IF NOT EXISTS students (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    name VARCHAR(100) NOT NULL,\n" +
                "    email VARCHAR(100),\n" +
                "    course_id INT,\n" +
                "    FOREIGN KEY (course_id) REFERENCES courses(id)\n" +
                ")";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();){
            boolean isExecute = statement.execute(sql);
            if (isExecute){
                System.out.println("Table Created Successfully");
            } else {
                System.out.println("Table Created UnSuccessfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean saveStudent(Students student) {
        String sql = "INSERT INTO students (name, email, course_id) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getEmail());
            statement.setLong(3, student.getCourse_id());

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows students inserted: " + rowsAffected);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public boolean updateStudent(Students student) {
        Students studentById = findStudentById(student.getId());
        if (studentById == null) {
            return false;
        }
        String sql = "UPDATE Students SET name=?, email=?, course_id=? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getEmail());
            statement.setLong(3, student.getCourse_id());
            statement.setLong(4, student.getId());

            int rows = statement.executeUpdate();
            return rows == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeStudent(Students student) {
        Students studentById = findStudentById(student.getId());
        if (studentById == null) {
            return false;
        }
        String sql = "DELETE FROM Students WHERE id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setLong(1, student.getId());
            int rows = statement.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Students> getAllStudents() {
        String sql = "SELECT id, name, email, course_id FROM students";
        List<Students> students = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                long course_id = resultSet.getLong("course_id");

                Students student = new Students(id, name, email, course_id);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public Students findStudentById(long id) {
        String sql = "SELECT * FROM Students WHERE id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                long course_id = resultSet.getLong("course_id");

                return new Students(id, name, email, course_id);
            } else {
                System.out.println("Student not found by id=" + id);
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
