package duilie;

public class ArrayQueue {//队列

    private int maxSize;//数组的长度
    private int front;//第一个数的位置
    private int rear;//最后一个数的位置
    private int[] arr;//创建的数组

    public ArrayQueue(int arrMaxSize){//初始化队列
        maxSize = arrMaxSize;
        arr =new int[arrMaxSize];
        front = -1;
        rear = -1;
    }
    public boolean isFull(){
        return rear == maxSize-1;
    }//队列是否已满

    public boolean isEmpty(){
        return  front == rear;
    }//队列是否为空

    public void  addQueue(int n){//添加元素
        if (isFull()){
            System.out.println("队列已满");
        }else {
            rear++;
            arr[rear]=n;
        }
    }
    public void getQueue(int n){//获取元素
        if (isEmpty()){
            System.out.println("队列为空");
        }else if (n>=arr.length){
            System.out.println("超出队列范围");
        }else {
            System.out.println("第"+n+"个数值为"+arr[n-1]);
        }

    }

    public void showQueue(){//展示队列
        if (isEmpty()){
            System.out.println("队列为空");
        }else {
            for (int i=0;i<rear+1;i++){
                System.out.print(arr[i]);
            }
            System.out.println("\r");
        }
    }



}

