package FirstExam;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;

public class Classroom<T, M> {
    private T id;
    private M name;

    public Classroom(T id, M name) {
        this.id = id;
        this.name = name;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public M getName() {
        return name;
    }

    public void setName(M name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

    public static void main(String[] args) {
        Classroom<Integer, String> class1 = new Classroom<>(1, "Vova");
        Classroom<Integer, String> class2 = new Classroom<>(2, "Ana");

        System.out.println(class1);

        System.out.println(class2);
    }
}
