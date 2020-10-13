package tree.HeapSort;

public class HeapSort {

    /*
    *堆排序
    *
    */
    public void heapSort(int[] arr){

        int temp;

        for (int i = arr.length / 2 -1;i>=0 ;i--){//调用方法进行堆排序，排出一个堆(多次比较找出最大的置于堆顶)
            adjustHeap(arr,i,arr.length);
        }

        for (int j = arr.length - 1;j>0;j--){//首尾交换，移除尾部，重新做堆(微调)
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }


    }

    /*
    *将一个数组(二叉树)，调整成一个大顶堆
    */
    public void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];
        for (int k = i * 2 + 1;k<length;k=k * 2 + 1){
            if (k < length && arr[k] < arr[k+1]){//说明左子节点的值小于右子节点的值
                k++;
            }
            if (arr[k] > temp) {//如果子节点大于父节点
                arr[i] = arr[k];//把较大的值赋给当前节点
                i = k;//i指向k，继续循环比较
            }else {
                break;
            }
        }
        arr[i] = temp;
    }

}
