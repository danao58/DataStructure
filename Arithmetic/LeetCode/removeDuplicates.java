package LiKou;

import org.junit.Test;

import java.util.Arrays;

public class removeDuplicates {
    @Test
    public void test(){
        int[] arr={0,0,1,1,1,2,2,3,3,4};
        int s =removeDuplicates(arr);
        System.out.println(Arrays.toString(arr)+s);

    }

    public int removeDuplicates(int[] nums) {
        if (nums.length ==0){//没有时返回空
            return 0;
        }
        int index = 0;//出现过一次的位置
        for(int i = 1;i<nums.length;i++){
            if (nums[index] != nums[i]){//未出现过，第一次出现交换
                index++;
                nums[index]=nums[i];
            }
        }

        return index+1;
    }

}
