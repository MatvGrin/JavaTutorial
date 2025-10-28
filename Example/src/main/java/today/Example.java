package today;

import java.io.*;
import java.util.Arrays;

public class Example implements Serializable {
    private static final long serialVersionUID = 1L;

    public String name;
    public int age;
    public String marka;
    public String ulica;
    public transient int id;
    public static String color;

    public Example(String name, int age, String marka, String ulica, int id, String color) {
        this.name = name;
        this.age = age;
        this.marka = marka;
        this.ulica = ulica;
        this.id = id;
        this.color = color;
    }


    @Override
    public String toString() {
        return "Example{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", marka='" + marka + '\'' +
                ", ulica='" + ulica + '\'' +
                ", id=" + id +
                ", color='" + color + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Example example1 = new Example("Vova", 35, "BMW", "wow", 1, "green");
        byte[] res = null;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)){

            oos.writeObject(example1);
            res = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(res));

        try (ByteArrayInputStream bais = new ByteArrayInputStream(res);
             ObjectInputStream ois = new ObjectInputStream(bais)){
            Example result = (Example) ois.readObject();
            System.out.println(result.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
