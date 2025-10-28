package secondExam;

import lombok.*;

import java.util.Objects;

public class Student extends Person implements University{
    private int id;

    public Student(String name, int age, int id) {
        super(name, age);
        this.id = id;
    }

    public Student(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void writeStudentInUniversity() {
        System.out.println(name + " was add in university");
    }

    @Override
    void work() {
        System.out.println("Learning");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
