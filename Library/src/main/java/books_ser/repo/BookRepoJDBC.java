package books_ser.repo;

import books_ser.config.DatabaseConnection;
import books_ser.entity.Author;
import books_ser.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepoJDBC implements BookRepository{

    @Override
    public Book createBook(Book book) {
        String sql = "INSERT INTO Books (title, published_year, genre, author_id) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statementBook = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            statementBook.setString(1, book.getTitle());
            statementBook.setLong(2, book.getPublishedYear());
            statementBook.setString(3, book.getGenre());
            statementBook.setLong(4, book.getId());

            int rowsAffected = statementBook.executeUpdate();
            System.out.println("Rows inserted: " + rowsAffected);

            ResultSet generatedKeys = statementBook.getGeneratedKeys();
            if (generatedKeys.next()) {
                long id = generatedKeys.getLong(1);
                book.setId(id);
            }else {
                System.out.println("Book wasn`t created");
                return null;
            }
            return book;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> getAllBooks() {
        String bookSql = "SELECT id, title, published_year, genre, author_id FROM Books";
        List<Book> books = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();) {

            ResultSet resultSetBook = statement.executeQuery(bookSql);
            while (resultSetBook.next()) {
                long id = resultSetBook.getLong("id");
                String title = resultSetBook.getString("title");
                long published_year = resultSetBook.getLong("published_year");
                String genre = resultSetBook.getString("genre");
                Book book = new Book(id, title, published_year, genre);
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public Book getBookById(long id) {
        Book book = null;
        String bookSql = "SELECT id, title, published_year, genre FROM Books where author_id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statementBook = connection.prepareStatement(bookSql);) {

            statementBook.setLong(1, id);
            ResultSet resultSetBook = statementBook.executeQuery();
            while (resultSetBook.next()) {
                long id1 = resultSetBook.getLong("id");
                String title = resultSetBook.getString("title");
                long published_year = resultSetBook.getLong("published_year");
                String genre = resultSetBook.getString("genre");
                book = new Book(id1, title, published_year, genre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public boolean updateBook(Book book) {
        Book bookById = getBookById(book.getId());
        if (bookById == null){
            return false;
        }
        String sql = "UPDATE Books SET title=?, published_year=?, genre=? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setString(1, book.getTitle());
            statement.setLong(2, book.getPublishedYear());
            statement.setString(3, book.getGenre());
            statement.setLong(4, book.getId());

            int rows = statement.executeUpdate();
            return rows == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteBook(long id) {
        if (id < 0){
            return false;
        }
        String sqlBook = "DELETE FROM Books WHERE author_id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statementBook = connection.prepareStatement(sqlBook);) {

            statementBook.setLong(1, id);
            int i = statementBook.executeUpdate();
            return i==1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        List<Book> books = new ArrayList<>();
        String bookSql = "SELECT id, title, published_year, genre FROM Books where genre = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statementBook = connection.prepareStatement(bookSql);) {
            statementBook.setString(1, genre);
            ResultSet resultSetBook = statementBook.executeQuery();
            while (resultSetBook.next()) {
                long id1 = resultSetBook.getLong("id");
                String title = resultSetBook.getString("title");
                long published_year = resultSetBook.getLong("published_year");
                Book bo = new Book(id1, title, published_year, genre);
                books.add(bo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }


    @Override
    public List<Book> getBooksByYear(long year) {
        List<Book> books = new ArrayList<>();
        String bookSql = "SELECT id, title, published_year, genre FROM Books where published_year = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statementBook = connection.prepareStatement(bookSql);) {
            statementBook.setLong(1, year);
            ResultSet resultSetBook = statementBook.executeQuery();
            while (resultSetBook.next()) {
                long id1 = resultSetBook.getLong("id");
                String title = resultSetBook.getString("title");
                String genre = resultSetBook.getString("genre");
                Book bo = new Book(id1, title, year, genre);
                books.add(bo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> getBooksByAuthorId(long authorId) {
        List<Book> books = new ArrayList<>();
        String bookSql = "SELECT id, title, published_year, genre FROM Books where author_id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statementBook = connection.prepareStatement(bookSql);) {
            statementBook.setLong(1, authorId);
            ResultSet resultSetBook = statementBook.executeQuery();
            while (resultSetBook.next()) {
                String title = resultSetBook.getString("title");
                long published_year = resultSetBook.getLong("published_year");
                String genre = resultSetBook.getString("genre");
                Book bo = new Book(authorId, title, published_year, genre);
                books.add(bo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> getBooksAfterYear(long year) {
        List<Book> books = new ArrayList<>();
        String bookSql = "SELECT id, title, published_year, genre FROM Books WHERE published_year > ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statementBook = connection.prepareStatement(bookSql)) {
            statementBook.setLong(1, year);
            try (ResultSet resultSetBook = statementBook.executeQuery()) {
                while (resultSetBook.next()) {
                    long id = resultSetBook.getLong("id");
                    String title = resultSetBook.getString("title");
                    long publishedYear = resultSetBook.getLong("published_year");
                    String genre = resultSetBook.getString("genre");
                    Book book = new Book(id, title, publishedYear, genre);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> getBooksByTitlePart(String titlePart) {
        List<Book> books = new ArrayList<>();
        String bookSql = "SELECT id, title, published_year, genre FROM Books WHERE title LIKE ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statementBook = connection.prepareStatement(bookSql)) {
            statementBook.setString(1, "%" + titlePart + "%");
            try (ResultSet resultSetBook = statementBook.executeQuery()) {
                while (resultSetBook.next()) {
                    long id = resultSetBook.getLong("id");
                    String title = resultSetBook.getString("title");
                    long publishedYear = resultSetBook.getLong("published_year");
                    String genre = resultSetBook.getString("genre");
                    Book book = new Book(id, title, publishedYear, genre);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
