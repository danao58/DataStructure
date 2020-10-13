package Search;

import java.util.Arrays;

public class FibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {1,8, 10, 89, 1000, 1234};
        System.out.println(fibSearch(arr,1));
    }
    public static int[] fib(){//斐波那契数列
        int[] f =new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        System.out.println(Arrays.toString(f));//前一个数＋后一个数产生第3个数
        return f;
    }
    public static int fibSearch(int[] a,int key){
        int low = 0;
        int high = a.length - 1;
        int k = 0;//分割数值的下标
        int mid = 0;
        int f[] = fib();//斐波那契数列

        while (high > f[k] - 1){//找到要查询的数组对应的斐波那契数列
            k++;
        }

        int[] temp = Arrays.copyOf(a,f[k]);//构造一个长度为f[k]的新数组，多出的会用0填充

        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];//高位填充为最大的那个数
        }
        //扩充成能找到分割点的数列
        System.out.println(Arrays.toString(temp));

        while (low <= high){//开始查询
            mid = low + f[k-1] -1;
            if (key < temp[mid]){//向左
                high = mid - 1;
                k--;
            }else if (key > temp[mid]){//向右
                low = mid + 1;
                k -= 2;
            }else {
                if (mid <= high){//在范围内
                    return mid;
                }else {
                    return high;//超出范围(可能是填充的)
                }
            }
        }
        return -1;
    }
}
