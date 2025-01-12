package array;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,5,8,10,15,18,20,25,28,35,40,45,48,49,50};
        int num = 20;
        System.out.println(binarySearch(arr, num));
        System.out.println(binarySearchRecursion(arr,0,arr.length-1,num));
    }

    static int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == key) {
                return middle;
            } else if (array[middle] < key) {
                left = middle + 1;
            } else if (array[middle] > key) {
                right = middle - 1;
            }
        }
        return -1;
    }
    static int binarySearchRecursion(int[] array, int left, int right, int key) {
        int middle = left + (right - left) / 2;
        if (array[middle] == key){
            return middle;
        }else if (array[middle] > key) {
            return binarySearchRecursion(array,left,middle-1, key);
        }else if (array[middle] < key) {
            return binarySearchRecursion(array,middle+1,right, key);
        }
        return -1;
    }
}
