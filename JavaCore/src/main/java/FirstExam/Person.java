package FirstExam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Person{
    private int id;
    public static void test(int id){
        System.out.println(id);
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.test(2);

    }
}
