package secondExam;

public class Demo {
    public static void main(String[] args) {
        Person student = new Student();
        student.setName("Vasya");
        student.setAge(45);
        System.out.println(student);
        student.work();

        System.out.println((student instanceof Person) ? "true" : "false");

        Person teacher = new Teacher("Max", 50);
        Polymorph polymorph = new Polymorph();
        polymorph.test(student);
        polymorph.test(teacher);

    }

}
class Polymorph {
    public void test(Person person) {
        System.out.println(person);
        person.work();
    }
}
