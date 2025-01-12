package books_ser.repo;

import books_ser.entity.Book;

import java.util.List;

public class BookRepoJDBC implements BookRepository{

    @Override
    public Book createBook(Book book) {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public Book getBookById(long id) {
        return null;
    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void deleteBook(long id) {

    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        return null;
    }

    @Override
    public List<Book> getBooksByYear(long year) {
        return null;
    }

    @Override
    public List<Book> getBooksByAuthorId(long authorId) {
        return null;
    }

    @Override
    public List<Book> getBooksAfterYear(long year) {
        return null;
    }

    @Override
    public List<Book> getBooksByTitlePart(String titlePart) {
        return null;
    }
}
