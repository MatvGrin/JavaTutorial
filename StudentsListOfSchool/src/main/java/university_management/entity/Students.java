package university_management.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Students {
    private long id;
    private String name;
    private String email;
    private long course_id;
}
