package FirstExam;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Animal implements Runnable{
    private int age;

    public void show(int age){
        System.out.println("Output: " + age);
    }
    @Override
    public void run() {
        System.out.println("Run animal");
    }
}

class Cat extends Animal implements Runnable{
    public Cat(int age) {
        super(age);
    }

    public static void main(String[] args) {
        Cat cat = new Cat(10);
        cat.show(50);

        Animal animal = new Animal(5);
        animal.run();

        Cat cat1= new Cat(5);
        cat.run();
    }
    @Override
    public void run() {
        System.out.println("Run cat");
    }
}
