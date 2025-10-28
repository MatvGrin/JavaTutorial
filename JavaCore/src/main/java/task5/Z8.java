package task5;

import java.util.Scanner;

public class Z8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rec1 = scanner.nextLine();
        String rec2 = scanner.nextLine();

        String[] r1 = rec1.split(" ");
        String[] r2 = rec2.split(" ");

        for (String r : r1) {
            System.out.println(r);
        }
        for (String r : r2) {
            System.out.println(r);
        }

        String naj = "";
        for (String r : r1) {
            if (r.length() > naj.length()) {
                naj = r;
            }
        }
        for (String r : r2) {
            if (r.length() > naj.length()) {
                naj = r;
            }
        }
        System.out.println("Najdulja riječ: " + naj + " i ima " + naj.length() + " slova!");
    }
}
