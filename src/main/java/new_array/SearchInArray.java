package new_array;

public class SearchInArray {
    public static void main(String[] args) {
        int[] arr = {10,15,19,52,36,8,5,9,4,7,89,47,20};
        printMaxElement(arr);
    }

    static void printMaxElement(int[] array){
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max){
                max = array[i];
            }
        }
        System.out.println("Max element in this array is " + max);
    }
}
