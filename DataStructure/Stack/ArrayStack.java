package zhan;

public class ArrayStack {

    private int maxSize;
    private int stack[];
    private int top = -1;

    public ArrayStack(int maxSize){//初始化栈
        this.maxSize = maxSize;
        stack =new int[this.maxSize];
    }


    public boolean isFull(){//栈满
        return top == maxSize - 1;
    }
    public boolean isEmpty(){//栈空
        return  top == -1;
    }

    public void push(int value){//入栈
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

    public int StackTop(){
        return  stack[top];
    }


    public void show(){//遍历栈
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0;i--) {
            System.out.println(stack[i]);
        }
    }


}
