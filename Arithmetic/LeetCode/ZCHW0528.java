package LiKou;

import java.awt.*;
import java.util.ArrayList;

public class ZCHW0528 {//最长回文字符串
    /*
    * 暴力解法
    * 中心回文串:从中心去
    * 动态规划：从两边来
    *Manacher 算法
    * */

    public static void main(String[] args) {
      ZCHW0528 test =new ZCHW0528();
      String s="abcda";
      System.out.println(test.longestPalindrome(s));

    }

    public String longestPalindrome(String s) {//暴力解法
        int len = s.length();
        if (len<2){
            return s;
        }
        int size = 0;
        int first =0;
        int last = 1;

        char[] array = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length();j++) {//遍历数组
                if (array[i]==array[j]){
                    if (isHui(array,i,j)){
                        if (size < (j-i)){
                            size =j-i;
                            first=i;
                            last = j+1;
                        }
                    }
                }
            }
        }

        return  s.substring(first,last);
    }


    public boolean isHui(char[] chars,int first,int last){
        int len = last - first;
        for (int i = 0; i <len ; i++) {
            if (chars[first] != chars[last]){
                return false;
            }
            first++;
            last--;
        }
        return true;
    }
}
