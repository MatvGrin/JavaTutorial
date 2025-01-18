package books_ser.repo;

import books_ser.entity.Author;

import java.util.List;

public interface AuthorRepository {
    Author createAuthor(Author author);
    List<Author> getAllAuthors();
    Author getAuthorById(long id);
    boolean updateAuthor(Author author);
    boolean deleteAuthor(long id);
    List<Author> getAuthorsByNationality(String nationality);
    List<Author> getAuthorsBySurname(String surname);
    List<Author> getAuthorsByName(String name);
    List<Author> getAuthorsByBookCount(long bookCount);
    List<Author> getAuthorsByBookGenre(String genre);
}
