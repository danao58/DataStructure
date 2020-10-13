package duilie;

public class CircleArrayQueue {
    private int maxSize;//数组的长度
    private int front;//第一个数的位置
    private int rear;//最后一个数的位置
    private int[] arr;//该数组用于存放数据

    public CircleArrayQueue(int arrMaxSize){//初始化队列
        maxSize = arrMaxSize;
        arr =new int[arrMaxSize];
        front = 0;
        rear = 0;
    }
    public boolean isFull()
    {
        return (rear+1)%maxSize==front;
    }//是否满
    public boolean isEmpty(){ return  rear==front; }//是否为空

    public void  addQueue(int n){//添加元素
        if (isFull()){
            System.out.println("队列已满");
        }else {
            arr[rear]=n;
            rear=(rear+1)%maxSize;
        }
    }


    public  void  delQueue(){//删除元素
        if (isEmpty()){
            System.out.println("队列为空");
        }else {
            front=(front+1)%maxSize;
        }
    }

    public void getQueue(int n){//获取元素
        if (isEmpty()){
            System.out.println("队列为空");
        }else if (n>=maxSize){
            System.out.println("超出队列范围");
        }else {
            System.out.println("第"+n+"个数值为"+arr[n]);
        }
    }

    public void showQueue(){//展示队列
        if (isEmpty()){
            System.out.println("队列为空");
        }else {
            for (int i=front;i<front+size();i++){
                System.out.println(arr[i%maxSize]);
            }
        }
    }

    public   int size(){
        return (rear+maxSize-front)%maxSize;
    }
}
