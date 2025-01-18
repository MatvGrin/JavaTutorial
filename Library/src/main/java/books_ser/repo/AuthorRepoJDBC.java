package books_ser.repo;

import books_ser.config.DatabaseConnection;
import books_ser.entity.Author;
import books_ser.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorRepoJDBC implements AuthorRepository {
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
        Author author = null;
        String sql = "Select * from Authors where id = ?";
        String bookSql = "SELECT id, title, published_year, genre FROM Books where author_id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             PreparedStatement statementBook = connection.prepareStatement(bookSql);) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String nationality = resultSet.getString("nationality");
                author = new Author(id, name, surname, nationality, new ArrayList<>());
            } else {
                System.out.println("Author not found by id=" + id);
                return null;
            }

            statementBook.setLong(1, id);
            ResultSet resultSetBook = statementBook.executeQuery();
            while (resultSetBook.next()) {
                long id1 = resultSetBook.getLong("id");
                String title = resultSetBook.getString("title");
                long published_year = resultSetBook.getLong("published_year");
                String genre = resultSetBook.getString("genre");
                Book book = new Book(id1, title, published_year, genre);
                author.getBooks().add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }

    @Override
    public boolean updateAuthor(Author author) {
        Author authorById = getAuthorById(author.getId());
        if (authorById == null) {
            return false;
        }
        String sql = "UPDATE Authors SET name=?, surname=?, nationality=? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setString(1, author.getName());
            statement.setString(2, author.getSurname());
            statement.setString(3, author.getNationality());
            statement.setLong(4, author.getId());

            int rows = statement.executeUpdate();
            return rows == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteAuthor(long id) {
        if (id < 0) {
            return false;
        }
        String sqlBook = "DELETE FROM Books WHERE author_id = ?";
        String sql = "DELETE FROM Authors WHERE id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statementBook = connection.prepareStatement(sqlBook);
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statementBook.setLong(1, id);
            statement.setLong(1, id);
            int i = statementBook.executeUpdate();
            int i1 = statement.executeUpdate();
            return i == 1 && i1 == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Author> getAuthorsByNationality(String nationality) {
        List<Author> authors = new ArrayList<>();
        String sql = "Select * from Authors where nationality = ?";
        String bookSql = "SELECT id, title, published_year, genre FROM Books where author_id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             PreparedStatement statementBook = connection.prepareStatement(bookSql);) {

            statement.setString(1, nationality);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                Author author = new Author(id, name, surname, nationality, new ArrayList<>());

                statementBook.setLong(1, id);
                ResultSet resultSetBook = statementBook.executeQuery();
                while (resultSetBook.next()) {
                    long id1 = resultSetBook.getLong("id");
                    String title = resultSetBook.getString("title");
                    long published_year = resultSetBook.getLong("published_year");
                    String genre = resultSetBook.getString("genre");
                    Book book = new Book(id1, title, published_year, genre);
                    author.getBooks().add(book);
                }
                authors.add(author);
            } else {
                System.out.println("Author not found by nationality=" + nationality);
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    @Override
    public List<Author> getAuthorsBySurname(String surname) {
        List<Author> authors = new ArrayList<>();
        String sql = "Select * from Authors where surname = ?";
        String bookSql = "SELECT id, title, published_year, genre FROM Books where author_id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             PreparedStatement statementBook = connection.prepareStatement(bookSql);) {

            statement.setString(1, surname);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String nationality = resultSet.getString("nationality");
                Author author = new Author(id, name, surname, nationality, new ArrayList<>());

                statementBook.setLong(1, id);
                ResultSet resultSetBook = statementBook.executeQuery();
                while (resultSetBook.next()) {
                    long id1 = resultSetBook.getLong("id");
                    String title = resultSetBook.getString("title");
                    long published_year = resultSetBook.getLong("published_year");
                    String genre = resultSetBook.getString("genre");
                    Book book = new Book(id1, title, published_year, genre);
                    author.getBooks().add(book);
                }
                authors.add(author);
            } else {
                System.out.println("Author not found by surname=" + surname);
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    @Override
    public List<Author> getAuthorsByName(String name) {
        List<Author> authors = new ArrayList<>();
        String sql = "Select * from Authors where name = ?";
        String bookSql = "SELECT id, title, published_year, genre FROM Books where author_id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             PreparedStatement statementBook = connection.prepareStatement(bookSql);) {

            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                long id = resultSet.getLong("id");
                String surname = resultSet.getString("surname");
                String nationality = resultSet.getString("nationality");
                Author author = new Author(id, name, surname, nationality, new ArrayList<>());

                statementBook.setLong(1, id);
                ResultSet resultSetBook = statementBook.executeQuery();
                while (resultSetBook.next()) {
                    long id1 = resultSetBook.getLong("id");
                    String title = resultSetBook.getString("title");
                    long published_year = resultSetBook.getLong("published_year");
                    String genre = resultSetBook.getString("genre");
                    Book book = new Book(id1, title, published_year, genre);
                    author.getBooks().add(book);
                }
                authors.add(author);
            } else {
                System.out.println("Author not found by name=" + name);
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }
}
