package array;

import java.sql.Array;
import java.util.Arrays;
import java.util.Base64;
import java.util.Iterator;

public class task1 {
    public static void main(String[] args) {
        double arr1[] = new double[12];
        double[] arr11 = new double[12];

        int arr2[] = new int[5];
        int b = 0;
        for (int i = 0; i < 5; i++) {
            arr2[i] = b++;
        }
        System.out.println(Arrays.toString(arr2));

        double num = 0.0;
        double arr3[] = {1.1,2.2,3.3,4.4,5.5,6.6,7.7,8.8,9.9,10.0};
        for (double i : arr3) {
            num += i;
        }
        System.out.println(num/arr3.length);

        String str[] = {"apple", "orange", "banana", "avokado", "strawberry"};
        Arrays.sort(str);
        for (String s : str) {
            System.out.println(s);
        }

        String a = "I like Java";
        System.out.println(a.indexOf("a"));
        System.out.println(a.lastIndexOf("a"));


        String str1 = "Мне нравится Java";
        int lengh = str1.length();
        char charat = str1.charAt(2);

        String st = "I like Java";
        String encod = Base64.getEncoder().encodeToString(st.getBytes());
        byte[] decoderByte = Base64.getDecoder().decode(encod);
        String decodStrig = new String(decoderByte);
        System.out.println(decodStrig);

        int x=10, y;
        y=(x < 0) ? 10 : 20;

        int abc = 15;
        int i1 = abc << 1;
        System.out.println(Integer.toBinaryString(i1));

        int[] nums = {3,5,7,2,9,-1,10,4,11};
        int min = nums[0];
        int max = nums[0];
        for (int i : nums) {
            if (i < min){
                min = i;
            }
            if (i > max){
                max = i;
            }
        }
        System.out.println("Min: "+ min + "," + "Max: "+ max);



    }
}
