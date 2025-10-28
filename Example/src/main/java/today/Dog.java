package today;

public class Dog extends Animals {
    private String control;

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String run() {
        return "Dog run";
    }

    @Override
    public String jump() {
        return "Dog jump";
    }

    public void setControl(String control) {
        this.control = control;
    }
    public String getControl() {
        return control;
    }
    public void down(String name){
        System.out.println("Down: " + name);
    }

    public static void main(String[] args) {
        Dog dog1 = new Dog("Bob", 5);
        dog1.up(dog1.getName());
        dog1.down(dog1.getName());
        dog1.setControl("Again");
        System.out.println(dog1.getControl());
    }

}
