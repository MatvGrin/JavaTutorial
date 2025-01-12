package university_management.repo;

import university_management.config.DatabaseConnection;
import university_management.entity.Teachers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepoSql implements TeacherRepo{

    {
        String sql = "CREATE TABLE IF NOT EXISTS teachers (\n" +
                "    id INT AUTO_INCREMENT NOT NULL,\n" +
                "    name VARCHAR(100) NOT NULL,\n" +
                "    subject VARCHAR(100) NOT NULL,\n" +
                "    course_id INT NOT NULL,\n" +
                "    PRIMARY KEY(id),\n" +
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
    public boolean saveTeacher(Teachers teacher) {
        String sql = "INSERT INTO teachers (name, subject, course_id) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setString(1, teacher.getFirstName());
            statement.setString(2, teacher.getSubject());
            statement.setLong(3, teacher.getCourse_id());

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows teachers inserted: " + rowsAffected);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public boolean updateTeacher(Teachers teacher) {
        Teachers existingTeacher = findTeacherById(teacher.getId());
        if (existingTeacher == null) {
            return false;
        }
        String sql = "UPDATE teachers SET name=?, subject=?, course_id=? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, teacher.getFirstName());
            statement.setString(2, teacher.getSubject());
            statement.setLong(3, teacher.getCourse_id());
            statement.setLong(4, teacher.getId());

            int rows = statement.executeUpdate();
            return rows == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeTeacher(Teachers teacher) {
        Teachers existingTeacher = findTeacherById(teacher.getId());
        if (existingTeacher == null) {
            return false;
        }
        String sql = "DELETE FROM teachers WHERE id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setLong(1, teacher.getId());
            int rows = statement.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Teachers> getAllTeachers() {
        String sql = "SELECT id, name, subject, course_id FROM teachers";
        List<Teachers> teachers = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String subject = resultSet.getString("subject");
                long courseId = resultSet.getLong("course_id");

                Teachers teacher = new Teachers(id, name, subject, courseId);
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teachers;
    }

    @Override
    public Teachers findTeacherById(long id) {
        String sql = "SELECT * FROM teachers WHERE id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String subject = resultSet.getString("subject");
                long courseId = resultSet.getLong("course_id");

                return new Teachers(id, name, subject, courseId);
            } else {
                System.out.println("Teacher not found by id=" + id);
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
