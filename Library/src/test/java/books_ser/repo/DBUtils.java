package books_ser.repo;

import books_ser.config.DatabaseConnection;

import java.io.*;
import java.sql.Connection;
import java.sql.Statement;

public class DBUtils {

    public static void initializeDatabase() {
        execute("src/test/resources/db.properties");
    }

    public static void deleteResources() {
        execute("src/test/resources/clean-db.properties");
    }

    private static void execute(String fileName) {
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();
             BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            StringBuilder sqlBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sqlBuilder.append(line);
                if (line.endsWith(";")) {
                    statement.execute(sqlBuilder.toString());
                    sqlBuilder.setLength(0);
                }
            }
        } catch (IOException | RuntimeException | java.sql.SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Не вдалося ініціалізувати базу даних", e);
        }
    }
}
