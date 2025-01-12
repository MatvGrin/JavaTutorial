package books_ser.repo;

import books_ser.entity.Author;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AuthorRepoJDBCTest {
    private static final Author AUTHOR = new Author();
    private AuthorRepository authorRepository = new AuthorRepoJDBC();

    @Before
    public void init(){
        DBUtils.initializeDatabase();
    }
    @After
    public void clean(){
        DBUtils.deleteResources();
    }
    @Test
    public void createAuthor() {
        Author author = new Author();
        author.setName("Mark");
        author.setSurname("Twain");
        author.setNationality("American");

        Author saveAuthor = authorRepository.createAuthor(author);
        assertEquals(11,saveAuthor.getId());
        assertEquals("Mark",saveAuthor.getName());
        assertEquals("Twain",saveAuthor.getSurname());
        assertEquals("American",saveAuthor.getNationality());
        final List<Author> all = authorRepository.getAllAuthors();
        System.out.println(all);
    }

    @Test
    public void getAllAuthors() {

    }

    @Test
    public void getAuthorById() {
    }

    @Test
    public void updateAuthor() {
    }

    @Test
    public void deleteAuthor() {
    }

    @Test
    public void getAuthorsByNationality() {
    }

    @Test
    public void getAuthorsBySurname() {
    }

    @Test
    public void getAuthorsByName() {
    }

    @Test
    public void getAuthorsByBookCount() {
    }

    @Test
    public void getAuthorsByBookGenre() {
    }
}