package zhan;

public class ArrayStack {//栈

    private int maxSize;//大小

    private int stack[];//栈数组

    private int top = -1;//栈顶

    public ArrayStack(int maxSize){//初始化栈

        this.maxSize = maxSize;

        stack =new int[this.maxSize];

    }


    //栈满
    public boolean isFull(){//栈满
        return top == maxSize - 1;
    }

    //空栈
    public boolean isEmpty(){//栈空
        return  top == -1;
    }

    //入栈
    public void push(int value){
        if (isFull()){

            System.out.println("栈满");

            return;
        }

        top++;

        stack[top] = value;
    }

    public int pop(){//出栈
        if (isEmpty()){

            throw new RuntimeException("栈空");

        }
        int value = stack[top];

        top--;

        return value;
    }

    //查看栈顶元素
    public int StackTop(){
        return stack[top];
    }


    //遍历栈
    public void show(){
        if (isEmpty()){

            System.out.println("栈空");

            return;
        }
        for (int i = top; i >= 0;i--) {

            System.out.println(stack[i]);

        }
    }


}
