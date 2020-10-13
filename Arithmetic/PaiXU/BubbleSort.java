package PaiXU;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] ={3,9,-1,10,20};
        BubbleSort bubbleSort = new BubbleSort();
       int[] end =  bubbleSort.bubbleSort(arr);
        for (int i = 0; i < end.length; i++) {
            System.out.println(end[i]);
        }

    }
    public int[] bubbleSort(int[] arr){
        /*冒泡排序
        * 前后两个数相比:大的后移
        * 循环一次找到一个大的数:减少排序次数
        *经过n-1次后完成排序
        * 优化：定义一个标记，如果一次都没有换，则说明已经排好序了
        * */
        int temp = 0;//中间变量
        int len =arr.length -1;//未排好序的个数
        boolean flag = false;

        while (len!=0){
            for (int i = 0; i < len; i++) {
                if (arr[i]>arr[i+1]){
                    temp =  arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    flag=true;
                }
            }
            if (!flag){
                break;
            }else {
                flag=false;
            }
            len--;
        }

        return arr;
    }
}
