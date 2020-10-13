package PaiXU;

public class InsertSort {
    public static void main(String[] args) {
        int arr[] ={9,3,-1,20,10};
        insertSort(arr);
    }

    public static void insertSort(int[] arr){//插入查询

        for (int i = 1; i < arr.length; i++) {//把第一个直接当作有序
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){//越界或小于原数完成交换
                arr[insertIndex + 1] =arr[insertIndex];//从后往前排
                insertIndex --;
            }
            arr[insertIndex + 1] = insertVal;//还原要排的数
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
