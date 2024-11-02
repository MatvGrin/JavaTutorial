package classAndOOP;

import java.util.*;
import java.util.stream.Collectors;

public class Ex3 {
    public static void main(String[] args) {
        String[] names = {"Anna", "Mike", "Sara", "Tom", "Bob", "Anna", "Mike"};
        List<String> collect = Arrays.stream(names)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);

        double[] number = {100.5, 200.75, 150.0, 300.25, 400.0, 500.0};
        OptionalDouble average = Arrays.stream(number)
                .average();
        System.out.println(average.orElse(0));

        int[] numbers = {3, 7, 2, 1, 5, 9, 8};
        OptionalInt max = Arrays.stream(numbers)
                .max();
        System.out.println(max.getAsInt());

        Product[] products = {
                new Product("Laptop", 1200.99),
                new Product("Phone", 800.50),
                new Product("Tablet", 450.75),
                new Product("Monitor", 300.40),
                new Product("Keyboard", 100.99)
        };
        Product max1 = Arrays.stream(products)
                .max(Comparator.comparing(Product::getPrice)).orElse(null);
        System.out.println(max1);

        int[] numbers2 = {15, 32, 45, 70, 18, 22, 33, 48, 61};
        int[] evenNumbers = Arrays.stream(numbers2)
                .filter(x -> x % 2 == 0).
                toArray();
        System.out.println(Arrays.toString(evenNumbers));

        String[] words = {"apple", "banana", "grape", "pineapple", "watermelon", "apple"};
        List<String> word = Arrays.stream(words)
                .filter(x -> x.length() > 5)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(word);

        Person[] people = {
                new Person("John", 25),
                new Person("Alice", 30),
                new Person("Mike", 40),
                new Person("Sara", 28),
                new Person("Tom", 35)
        };
        OptionalDouble average1 = Arrays.stream(people)
                .mapToInt(Person::getAge)
                .average();
        System.out.println(average1.getAsDouble());


    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}