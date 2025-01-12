package enummeration;

import java.util.ArrayList;
import java.util.List;

public class En2 {
    public static void main(String[] args) {
        Counter counter = new Counter(50);
        Integer a = (Integer) counter.getValue();
        System.out.println(a*5);
        Counter counter1 = new Counter("Vova");
//        Integer b = (Integer) counter1.getValue();
//        System.out.println(b*5);
        List arr = new ArrayList();
        arr.add(20);
        System.out.println(arr);

    }
}
class Counter{
    private Object value;

    public Counter(Object o) {
        this.value = o;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
//3
//public class FlightSched<T, U> {
//}
//4
//public class FlightSched<T, U extends Thread> {
//}
//5
//public class FlightSched<T, U extends T> {
//}
//8
//public <T> T MyGen(T obj) {
//        return obj;
//        }
//        9
//public interface IGenStack<T> {
//    void push(T item);
//    T pop();
//}
//interface IGenIF<T, V extends T>{
//
//}
//class MyClass<T, V extends T> implements IGenIF<T, V> {
//}

