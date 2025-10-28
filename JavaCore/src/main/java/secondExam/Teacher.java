package secondExam;

import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
public class Teacher extends Person {

    public Teacher(String name, int  age){
        super(name, age);
    }

    @Override
    void work() {
        System.out.println("Teacher works");
    }

}
