package array;

class Queue {
    private char[] stackArray;
    private int top;

    public Queue(int size) {
        stackArray = new char[size];
        top = -1;
    }

    public void push(char item) {
        if (top == stackArray.length - 1) {
            System.out.println("Стек переполнен.");
        } else {
            stackArray[++top] = item;
        }
    }

    public char pop() {
        if (top < 0) {
            System.out.println("Стек пуст.");
            return ' ';
        } else {
            return stackArray[top--];
        }
    }
}