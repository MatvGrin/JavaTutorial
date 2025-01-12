package books_ser.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Author {
    private long id;
    private String name;
    private String surname;
    private String nationality;
    private List<Book> books;
}
