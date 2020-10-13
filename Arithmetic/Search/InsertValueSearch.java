package Search;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i+1;
        }
        int result = insertValueSearch(arr,0,arr.length-1,10);
        System.out.println(result);
    }
    public static int insertValueSearch(int[] arr,int left,int right,int findVal){//插值查找
        if (left > right || findVal < arr[0] || findVal > arr[arr.length-1]){
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal){//向右递归
            return insertValueSearch(arr,mid+1,right,findVal);
        }else if (findVal < mid){//向左递归
            return insertValueSearch(arr,left,mid-1,findVal);
        }else {
            return mid;
        }
    }

}
