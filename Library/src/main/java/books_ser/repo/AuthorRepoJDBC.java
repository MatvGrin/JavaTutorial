package books_ser.repo;

import books_ser.config.DatabaseConnection;
import books_ser.entity.Author;
import books_ser.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorRepoJDBC implements AuthorRepository{
    @Override
    public Author createAuthor(Author author) {
        String sql = "INSERT INTO Authors (name, surname, nationality) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            statement.setString(1, author.getName());
            statement.setString(2, author.getSurname());
            statement.setString(3, author.getNationality());

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows inserted: " + rowsAffected);

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                long id = generatedKeys.getLong(1);
                author.setId(id);
            }
            return author;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Author> getAllAuthors() {
        String authorSql = "SELECT id, name, surname, nationality FROM Authors";
        Map<Long, Author> authors = new HashMap<>();
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();) {

            ResultSet resultSet = statement.executeQuery(authorSql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String nationality = resultSet.getString("nationality");
                Author author = new Author(id, name, surname, nationality, new ArrayList<>());
                authors.put(id, author);
            }

            String bookSql = "SELECT id, title, published_year, genre, author_id FROM Books";
            ResultSet resultSetBook = statement.executeQuery(bookSql);
            while (resultSetBook.next()) {
                long id = resultSetBook.getLong("id");
                String title = resultSetBook.getString("title");
                long published_year = resultSetBook.getLong("published_year");
                String genre = resultSetBook.getString("genre");
                long author_id = resultSetBook.getLong("author_id");
                Book book = new Book(id, title, published_year, genre);
                authors.get(author_id).getBooks().add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>(authors.values());
    }

    @Override
    public Author getAuthorById(long id) {
        String sql = "Select * from Authors where id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);){

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
//                String title = resultSet.ge
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateAuthor(Author author) {

    }

    @Override
    public void deleteAuthor(long id) {

    }

    @Override
    public List<Author> getAuthorsByNationality(String nationality) {
        return null;
    }

    @Override
    public List<Author> getAuthorsBySurname(String surname) {
        return null;
    }

    @Override
    public List<Author> getAuthorsByName(String name) {
        return null;
    }

    @Override
    public List<Author> getAuthorsByBookCount(long bookCount) {
        return null;
    }

    @Override
    public List<Author> getAuthorsByBookGenre(String genre) {
        return null;
    }
}
