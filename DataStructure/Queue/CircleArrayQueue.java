package duilie;

public class CircleArrayQueue {//循环队列

    private int maxSize;//数组的长度

    private int front;//第一个数的位置

    private int rear;//最后一个数的位置

    private int[] arr;//该数组用于存放数据

    //初始化队列
    public CircleArrayQueue(int arrMaxSize){

        maxSize = arrMaxSize;

        arr =new int[arrMaxSize];//该处会少用一个空间。假溢出。用%来循环

        front = 0;

        rear = 0;
    }

    //是否满
    public boolean isFull()
    {
        return (rear + 1) % maxSize == front;
    }

    //是否为空
    public boolean isEmpty(){ return  rear == front; }

    //添加元素
    public void  addQueue(int n){

        if (isFull()){

            System.out.println("队列已满");

        }else {

            arr[rear] = n;

            rear = (rear + 1) % maxSize;
        }
    }


    //删除元素
    public  void  delQueue(){

        if (isEmpty()){

            System.out.println("队列为空");

        }else {

            front = ( front + 1) % maxSize;
        }
    }

    //获取元素
    public void getQueue(int n){

        if (isEmpty()){

            System.out.println("队列为空");

        }else if (n >= maxSize){

            System.out.println("超出队列范围");

        }else {

            System.out.println("第" + n + "个数值为" + arr[n]);
        }
    }

    //展示队列
    public void showQueue(){

        if (isEmpty()){

            System.out.println("队列为空");

        }else {

            for (int i = front;i < front + size();i++){

                System.out.println(arr[i % maxSize]);

            }
        }
    }

    //获取个数
    public   int size(){
        return (rear + maxSize - front ) % maxSize;
    }
}
