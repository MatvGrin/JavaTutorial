package secondExam;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
abstract class Person {
    protected String name;
    protected int age;
    abstract void work();
}
