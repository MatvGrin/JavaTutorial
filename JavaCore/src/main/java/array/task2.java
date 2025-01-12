package array;

class task2 {
    static int sum(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }
    static int sum(String ab, int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }
    public static void main(String[] args) {
        System.out.println(sum(1, 2, 3));
        System.out.println(sum(4, 5));
    }
}
