package PaiXU;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int arr[]={53,3,542,748,14,214};
        radixSort(arr);
    }
    public static void radixSort(int[] arr){//基数排序
        int[][] bucket=new int[10][arr.length];//10个桶（空间换时间）
        int[] bucketElementCounts = new int[10];//每个桶中个数

        int max =arr[0];
        for (int i = 0; i < arr.length; i++) {//找出数组中最大位数
            if (arr[i]>max){
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        for (int j = 0,n=1; j < maxLength; j++,n*=10) {//按个十百。。。来分
            for (int i = 0; i < arr.length; i++) {//将数放入桶中
                int digitOfElement = arr[i] / n  % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] =arr[i];
                bucketElementCounts[digitOfElement]++;
            }

            int index = 0;
            int r=0;
            for (int i = 0; i < arr.length;) {//从桶中取出数
                if (bucketElementCounts[index]>0){
                    arr[i]=bucket[index][r];
                    r++;
                    i++;
                    bucketElementCounts[index]--;
                }else {
                    r=0;
                    index++;
                }
            }
        }



        System.out.println(Arrays.toString(arr));
        
    }
}
