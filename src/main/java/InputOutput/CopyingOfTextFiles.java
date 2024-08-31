package InputOutput;

import java.io.*;

public class CopyingOfTextFiles {
    public static void main(String[] args) {
        String in = "input.txt";
        String ou = "output.txt";
        try (FileReader fr = new FileReader(in);
             FileWriter fw = new FileWriter(ou)) {

            int ch = fr.read();
            while (ch != -1) {
                fw.write(ch);
                ch = fr.read();
            }

            System.out.println("Зробив діло гуляй сміло!!!, Файл скопійовоно!!!");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
