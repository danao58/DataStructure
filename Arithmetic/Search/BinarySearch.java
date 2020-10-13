package Search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,1,8,10,89,1000,1000,1000,1234};//数组必须有序
        binarySearch(arr,0,arr.length-1,1);
    }

    public static void binarySearch(int[] arr,int left,int right,int findVal){//二分查找
        int mid =(left + right) / 2 ;
        if(left > right){
            System.out.println("查无此数");
        }else if (arr[mid]==findVal){
            System.out.println(mid);
            int temp = mid;
            while (mid+1 < arr.length) {
                if (arr[mid + 1] == findVal) {
                    mid++;
                    System.out.println(mid);
                }else {
                    mid = arr.length;
                }
            }
            mid = temp;
            while (mid - 1 > -1){
                if (arr[mid - 1] == findVal) {
                    mid--;
                    System.out.println(mid);
                }else {
                    mid = 0;
                }
            }
        }else if (arr[mid]>findVal){//向左递归
            binarySearch(arr,left,mid-1,findVal);
        }else if (arr[mid]<findVal){//向右递归
            binarySearch(arr,mid+1,right,findVal);
        }

    }
}
