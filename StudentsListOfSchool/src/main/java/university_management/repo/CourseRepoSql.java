package university_management.repo;

import university_management.config.DatabaseConnection;
import university_management.entity.Courses;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepoSql implements CourseRepo{

    {
        String sql = "CREATE TABLE IF NOT EXISTS courses (\n" +
                "    id INT AUTO_INCREMENT NOT NULL,\n" +
                "    name VARCHAR(100) NOT NULL,\n" +
                "    duration INT NOT NULL,\n" +
                "    PRIMARY KEY(id)\n" +
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
    public boolean saveCourse(Courses course) {
        String sql = "INSERT INTO courses  (name, duration) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setString(1, course.getName());
            statement.setLong(2, course.getDuration());
            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows courses inserted: " + rowsAffected);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public boolean updateCourse(Courses course) {
        Courses courseById = findCourseById(course.getId());
        if (courseById == null) {
            return false;
        }
        String sql = "UPDATE courses  SET name=?, duration=? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, course.getName());
            statement.setLong(2, course.getDuration());
            statement.setLong(3, course.getId());

            int rows = statement.executeUpdate();
            return rows == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeCourse(Courses course) {
        Courses courseById = findCourseById(course.getId());
        if (courseById == null) {
            return false;
        }
        String sql = "DELETE FROM courses WHERE id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setLong(1, course.getId());
            int rows = statement.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Courses> getAllCourses() {
        String sql = "SELECT id, name, duration FROM courses";
        List<Courses> courses = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                long duration = resultSet.getLong("duration");

                Courses course = new Courses(id, name, duration);
                courses.add(course);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courses;
    }

    @Override
    public Courses findCourseById(long id) {
        String sql = "SELECT * FROM courses WHERE id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                long duration  = resultSet.getLong("duration ");

                return new Courses(id, name, duration);
            } else {
                System.out.println("Course not found by id=" + id);
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
