package enummeration;

enum Tools {
    SCREWDRIVER, WRENCH, НАММЕR, PLIERS
}
public class En1 {
    public static void main(String[] args) {
        for (Tools value : Tools.values()) {
            System.out.println(value + " index: " + value.ordinal());
        }
    }
}
