package books_ser.repo;

import books_ser.entity.Book;

import java.util.List;

public interface BookRepository {
    Book createBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(long id);
    boolean updateBook(Book book);
    boolean deleteBook(long id);
    List<Book> getBooksByGenre(String genre);
    List<Book> getBooksByYear(long year);
    List<Book> getBooksByAuthorId(long authorId);
    List<Book> getBooksAfterYear(long year);
    List<Book> getBooksByTitlePart(String titlePart);
}
