package today;

public class Cat extends Animals{
    private String control;

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String run() {
        return "Cat run";
    }

    @Override
    public String jump() {
        return "Cat jump";
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
        Cat cat1 = new Cat("Meri", 5);
        cat1.up(cat1.getName());
        cat1.down(cat1.getName());
        cat1.setControl("Again");
        System.out.println(cat1.getControl());


    }

}
