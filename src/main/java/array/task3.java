package array;

class Test {
    int a;
    Test(int i) {
        a = i;
    }
    static void swap(Test obj1, Test obj2) {
        int temp = obj1.a;
        obj1.a = obj2.a;
        obj2.a = temp;
    }
}
