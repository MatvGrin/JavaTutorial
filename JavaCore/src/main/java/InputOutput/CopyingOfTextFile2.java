package InputOutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyingOfTextFile2 {
    public static void main(String[] args) {
        String input = "input.txt";
        String output = "output.txt";
        FileInputStream fis = null;
        FileOutputStream fio = null;

        try {
            fis = new FileInputStream(input);
            fio = new FileOutputStream(output);

            int byteData;
            while ((byteData = fis.read()) != -1){
                if (byteData == ' ') {
                    fio.write('-');
                } else {
                    fio.write(byteData);
                }
            }
            System.out.println("Успешно!!!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fio != null) {
                try {
                    fio.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
