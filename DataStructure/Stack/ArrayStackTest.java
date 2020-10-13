package zhan;

public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);

        arrayStack.push(5);
        arrayStack.push(4);
        arrayStack.push(2);
        arrayStack.push(9);
        arrayStack.push(8);

        arrayStack.show();
        System.out.println("======================");
        arrayStack.pop();
        arrayStack.pop();

        arrayStack.show();


    }
}
