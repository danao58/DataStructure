package PaiXU;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static  void quickSort(int[] arr,int l,int r){//快速排序
        int left = l;
        int right = r;
        int pivot = arr[(left + right)/2];//中值
        int temp = 0;
        //比pivot值大放到右边
        while (left < right){
            //在pivot左边找，找到大于的退出
            while (arr[left] < pivot){
                left += 1;
            }
            //在pivot右边找，找到了小于的退出
            while (arr[right] > pivot){
                right -=1;
            }
            if(left>=right){
                break;
            }

            //两边都有就交换
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            //相等不管
            if (arr[left] == pivot){
                right -= 1;
            }

            if (arr[right] == pivot){
                left +=1;
            }
        }

        if (left == right){
            left += 1;
            right -= 1;
        }

        if (l < right){
            quickSort(arr,l,right);
        }

        if (r > left){
            quickSort(arr,left,r);
        }
    }
}
