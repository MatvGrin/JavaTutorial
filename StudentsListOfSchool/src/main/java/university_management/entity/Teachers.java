package university_management.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Teachers {
    private long id;
    private String firstName;
    private String subject;
    private long course_id;
}
