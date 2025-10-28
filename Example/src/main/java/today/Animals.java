package today;

public class Animals {
    private String name;
    private int age;

    public Animals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void up(String name){
        System.out.println("Up: " + name);
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
        return "Animals{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String run() {
        return "";
    }

    public String jump() {
        return "";
    }

    public static void main(String[] args) {
        Animals animals1 = new Dog("", 500);
        Animals animals2 = new Cat("", 500);
        test(animals1);
        test(animals2);
    }

    public static void test(Animals animals) {
        System.out.println(animals.run());
        System.out.println(animals.jump());
    }
}
