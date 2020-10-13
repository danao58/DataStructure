package PaiXU;

import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        int arr[] =new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (int) (Math.random()*8000000);
        }
        Date date1 = new Date();
        System.out.println(date1);

        selectSort(arr);

        Date date2 = new Date();
        System.out.println(date2);


    }
    public static void selectSort(int[] arr){//选择排序
        int minIndex = 0;//最小数索引
        int temp = 0;//中间变量

        for (int j = 0; j < arr.length-1; j++) {//遍历

            minIndex = j;//重置最小数索引为第一个数

            for (int i = j+1; i < arr.length; i++) {//找出最小数
                if (arr[minIndex]>arr[i]){
                    minIndex = i;
                }
            }


                //交换
                temp = arr[j];
                arr[j] = arr[minIndex];
                arr[minIndex] = temp;



        }

       /* for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }*/

    }
}
