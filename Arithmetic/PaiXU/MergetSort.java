package PaiXU;

import java.util.Arrays;

public class MergetSort {
    public static void main(String[] args) {
        int arr[] = {8,4,5,7,1,3,6,2};
        int temp[] = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr,int left,int right,int[] temp){//分
        if (left < right){//分到最小为止
            int mid =(left + right)/2;//找出中间数
            mergeSort(arr,left,mid,temp);//左边递归分
            mergeSort(arr,mid + 1,right,temp);//右边递归分
            merge(arr,left,mid,right,temp);//合
        }
    }

    public static void  merge(int[] arr,int left,int mid,int right,int[] temp){//合
        int i = left;//左边初始化序列的索引
        int j = mid + 1;//右边初始化序列的索引
        int t = 0;//指向temp数组的索引

        while (i <= mid && j <= right){//左右比较，大的到temp中去
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        //剩下的直接全部到temp里
        while (i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }

       while (j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }
        //还原数组
        t=0;
        int tempLeft = left;
        while (tempLeft<=right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }
}
