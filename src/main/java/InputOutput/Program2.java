package InputOutput;

import java.io.FileInputStream;
import java.io.IOException;

public class Program2 {
    public static void main(String[] args) {

        try(FileInputStream fin=new FileInputStream("notes.txt"))
        {
            int i;
            while((i=fin.read())!=-1){

                System.out.print((char)i);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
