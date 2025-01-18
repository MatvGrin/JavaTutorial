package books_ser.repo;

import books_ser.entity.Author;
import books_ser.entity.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AuthorRepoJDBCTest {
    private static final Author AUTHOR = new Author();
    private final AuthorRepository authorRepository = new AuthorRepoJDBC();

    @Before
    public void init(){
        DBUtils.initializeDatabase();
        AUTHOR.setId(3);
        AUTHOR.setName("Mark");
        AUTHOR.setSurname("Twain");
        AUTHOR.setNationality("American");
    }

    @After
    public void clean(){
        DBUtils.deleteResources();
    }

    @Test
    public void createAuthor() {
        Author saveAuthor = authorRepository.createAuthor(AUTHOR);
        assertEquals(11,saveAuthor.getId());
        assertEquals("Mark",saveAuthor.getName());
        assertEquals("Twain",saveAuthor.getSurname());
        assertEquals("American",saveAuthor.getNationality());
    }

    @Test
    public void getAllAuthors() {
        final List<Author> all = authorRepository.getAllAuthors();

        assertEquals(10, all.size());
        assertTrue(all.size() == 10);
        assertFalse(all.isEmpty());
    }

    @Test
    public void getAuthorById() {
        Book book = new Book(2, "Pride and Prejudice", 1813, "Romance");
        List<Book> books = Arrays.asList(book);
        Author author = new Author(2, "Jane", "Austen", "British", books);

        Author authorById = authorRepository.getAuthorById(2);

        assertEquals(author, authorById);
    }

    @Test
    public void updateAuthor() {
        boolean authorUpdate = authorRepository.updateAuthor(AUTHOR);
        assertTrue(authorUpdate);
    }

    @Test
    public void deleteAuthor() {
        boolean authorDelete = authorRepository.deleteAuthor(4);
        assertTrue(authorDelete);
        Author authorById = authorRepository.getAuthorById(4);
        assertNull(authorById);
    }

    @Test
    public void getAuthorsByNationality() {
        Book book = new Book(4, "Norwegian Wood", 1987, "Romance");
        List<Book> books = List.of(book);
        Author author = new Author(4, "Haruki", "Murakami", "Japanese", books);
        List<Author> authors = List.of(author);

        List<Author> authorByNationality = authorRepository.getAuthorsByNationality("Japanese");

        assertEquals(authors, authorByNationality);
    }

    @Test
    public void getAuthorsBySurname() {
        Book book = new Book(1, "One Hundred Years of Solitude", 1967, "Magic Realism");
        Book book2 = new Book(11, "The Autumn of the Patriarch", 1952, "Magic Realism");
        List<Book> books = List.of(book,book2);
        Author author = new Author(1, "Gabriel", "Garcia Marquez", "Colombian", books);
        List<Author> authors = List.of(author);

        List<Author> authorBySurname = authorRepository.getAuthorsBySurname("Garcia Marquez");

        assertEquals(authors, authorBySurname);
    }

    @Test
    public void getAuthorsByName() {
        Book book = new Book(1, "One Hundred Years of Solitude", 1967, "Magic Realism");
        Book book2 = new Book(11, "The Autumn of the Patriarch", 1952, "Magic Realism");
        List<Book> books = List.of(book, book2);
        Author author = new Author(1, "Gabriel", "Garcia Marquez", "Colombian", books);
        List<Author> authors = List.of(author);

        List<Author> authorByName = authorRepository.getAuthorsByName("Gabriel");

        assertEquals(authors, authorByName);
    }

    @Test
    public void getAuthorsByBookCount() {
        Book book1 = new Book(1, "One Hundred Years of Solitude", 1967, "Magic Realism");
        Book book2 = new Book(11, "The Autumn of the Patriarch", 1952, "Magic Realism");
        Author author1 = new Author(1, "Gabriel", "Garcia Marquez", "Colombian", List.of(book1, book2));

        List<Author> expectedAuthors = List.of(author1);
        List<Author> authorsByBookCount = authorRepository.getAuthorsByBookCount(2);

        assertEquals(expectedAuthors, authorsByBookCount);
    }

    @Test
    public void getAuthorsByBookGenre() {
        Book book = new Book(3, "Adventures of Huckleberry Finn", 1884, "Adventure");
        List<Book> books = List.of(book);

        Author author = new Author(3, "Mark", "Twain", "American", books);
        List<Author> authors = List.of(author);

        List<Author> authorByGenre = authorRepository.getAuthorsByBookGenre("Adventure");

        assertEquals(authors, authorByGenre);
    }
}
