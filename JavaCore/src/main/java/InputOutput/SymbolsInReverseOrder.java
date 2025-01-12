package InputOutput;

import java.io.*;

public class SymbolsInReverseOrder {
    public static void main(String[] args) {
        String st = "start.txt";
        String fi = "finish.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(st));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fi))){

            String line;
            while ((line = reader.readLine()) != null){
                String rev = new StringBuilder(line).reverse().toString();
                writer.write(rev);
                writer.newLine();
            }
            System.out.println("Super!!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
