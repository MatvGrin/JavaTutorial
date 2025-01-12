package books_ser.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Book {
    private long id;
    private String title;
    private long publishedYear;
    private String genre;
}
