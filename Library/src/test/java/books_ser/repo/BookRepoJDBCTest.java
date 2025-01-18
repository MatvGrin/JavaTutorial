package books_ser.repo;

import books_ser.entity.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BookRepoJDBCTest {
    private static final Book BOOK = new Book();
    private final BookRepository bookRepository = new BookRepoJDBC();

    @Before
    public void init(){
        DBUtils.initializeDatabase();
        BOOK.setTitle("One Hundred Years of Solitude");
        BOOK.setPublishedYear(1967);
        BOOK.setGenre("Magic Realism");
        BOOK.setId(1);
    }
    @After
    public void clean(){
        DBUtils.deleteResources();
    }
    @Test
    public void createBook() {
        Book saveBook = bookRepository.createBook(BOOK);
        assertEquals("One Hundred Years of Solitude",saveBook.getTitle());
        assertEquals(1967,saveBook.getPublishedYear());
        assertEquals("Magic Realism",saveBook.getGenre());
        assertEquals(11,saveBook.getId());
    }

    @Test
    public void getAllBooks() {
        final List<Book> all = bookRepository.getAllBooks();

        assertEquals(10, all.size());
        assertTrue(all.size() == 10);
        assertFalse(all.isEmpty());
    }

    @Test
    public void getBookById() {
        Book book = new Book(1, "One Hundred Years of Solitude", 1967, "Magic Realism");

        Book bookById = bookRepository.getBookById(1);

        assertEquals(book, bookById);
    }

    @Test
    public void updateBook() {
        boolean bookUpdate = bookRepository.updateBook(BOOK);
        assertTrue(bookUpdate);
    }

    @Test
    public void deleteBook() {
        boolean bookDelete = bookRepository.deleteBook(4);
        assertTrue(bookDelete);
        Book bookById = bookRepository.getBookById(4);
        assertNull(bookById);
    }

    @Test
    public void getBooksByGenre() {
        Book book = new Book(1, "One Hundred Years of Solitude", 1967, "Magic Realism");
        List<Book> bokk = new ArrayList<>();
        bokk.add(book);
        List<Book> bookByGenre = bookRepository.getBooksByGenre("Magic Realism");

        assertEquals(bokk, bookByGenre);
    }

    @Test
    public void getBooksByYear() {
        Book book = new Book(1, "One Hundred Years of Solitude", 1967, "Magic Realism");
        List<Book> bokk = new ArrayList<>();
        bokk.add(book);
        List<Book> bookByYear = bookRepository.getBooksByYear(1967);

        assertEquals(bokk, bookByYear);
    }

    @Test
    public void getBooksByAuthorId() {
        Book book = new Book(1, "One Hundred Years of Solitude", 1967, "Magic Realism");
        List<Book> bokk = new ArrayList<>();
        bokk.add(book);
        List<Book> bookByAuthorId = bookRepository.getBooksByAuthorId(1);

        assertEquals(bokk, bookByAuthorId);
    }

    @Test
    public void getBooksAfterYear() {
        Book book = new Book(1, "One Hundred Years of Solitude", 1967, "Magic Realism");
        Book book4 = new Book(4, "Norwegian Wood", 1987, "Romance");
        Book book7 = new Book(7, "Harry Potter and the Philosophers Stone", 1997, "Fantasy");
        Book book8 = new Book(8, "Harry Potter and the Chamber of Secrets", 1998, "Fantasy");
        List<Book> bokk = new ArrayList<>();
        bokk.add(book);
        bokk.add(book4);
        bokk.add(book7);
        bokk.add(book8);
        List<Book> bookByAuthorId = bookRepository.getBooksAfterYear(1965);

        assertEquals(bokk, bookByAuthorId);
    }

    @Test
    public void getBooksByTitlePart() {
        Book book1 = new Book(7, "Harry Potter and the Philosophers Stone", 1997, "Fantasy");
        Book book2 = new Book(8, "Harry Potter and the Chamber of Secrets", 1998, "Fantasy");
        List<Book> expectedBooks = List.of(book1, book2);

        List<Book> booksByTitlePart = bookRepository.getBooksByTitlePart("Harry");

        assertEquals(expectedBooks.size(), booksByTitlePart.size());
        assertEquals(expectedBooks, booksByTitlePart);
    }
}