package zhan;

public class ArrayStackTest {//测试类

    public static void main(String[] args) {

        ArrayStack arrayStack = new ArrayStack(5);

        arrayStack.push(5);
        arrayStack.push(4);
        arrayStack.push(2);
        arrayStack.push(9);
        arrayStack.push(8);


        System.out.println("==========栈中数据============");

        System.out.println("栈顶:"+arrayStack.StackTop() );

        arrayStack.show();



        arrayStack.pop();
        arrayStack.pop();

        System.out.println("==========栈中数据============");

        arrayStack.show();


    }
}
