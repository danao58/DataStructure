package Search;

public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr={1,1,8,10,89,1000,1000,1000,1234};//数组必须有序
        System.out.println(binarySearch(arr,1) );
    }

    public static int binarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] == target){
                return mid;
            }else if (arr[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
