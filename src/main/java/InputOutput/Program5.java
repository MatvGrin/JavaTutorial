package InputOutput;

import java.io.*;

public class Program5 {
    public static void main(String[] args) {
        FileInputStream fin=null;
        try
        {
            fin = new FileInputStream("D://notes.txt");

            int i=-1;
            while((i=fin.read())!=-1){

                System.out.print((char)i);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        finally{

            try{

                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        }
    }
}
