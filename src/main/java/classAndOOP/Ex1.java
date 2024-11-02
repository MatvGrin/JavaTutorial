package classAndOOP;

interface StrUtil{
    String changeSTR(String a);
}

public class Ex1 {
    public static void main(String[] args) {
        StrUtil str = (s) -> {
            String s1 = s.replaceAll(" ", "");
            return s1;
        };
        System.out.println(str.changeSTR("My father is very good teacher!!!"));
        StrUtil str2 = (s) -> {
            String s1 = s.toUpperCase();
            return s1;
        };
        System.out.println(str2.changeSTR("My father is very good teacher!!!"));
//        MyFunc myFunc = MyClass::myStaticMethod;
//        myFunc.func();
    }
}
