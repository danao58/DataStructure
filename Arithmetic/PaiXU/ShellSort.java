package PaiXU;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr ={8,9,1,7,2,3,5,4,6,0};
        shellSort(arr);
    }

    public static void shellSort(int[] arr){//交换式
        int temp = 0;
        for (int gap =  arr.length / 2; gap >0 ; gap /= 2) {
            for (int i = gap; i < arr.length ; i++){
                for (int k = i-gap; k >= 0; k-=gap) {
                    if (arr[k]>arr[k+gap]){
                        temp = arr[k];
                        arr[k]=arr[k+gap];
                        arr[k+gap]=temp;
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
    public static void shellSort2(int[] arr){//移位式
        for (int gap =  arr.length / 2; gap >0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j-gap]){
                    while (j - gap >=0 && temp <arr[j-gap]){
                        arr[j] = arr[j-gap];
                        j -=gap;
                    }
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
