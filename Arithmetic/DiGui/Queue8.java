package DiGui;

public class Queue8 {
    int max=8;//皇后的个数
    int[] array = new  int[max];//列数
    static int count = 0;//有多少种可行的方法

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(count);
    }

    private void check(int n){//运行
        if (n == max){//是否到达追后一个
            print();//输出
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;//循环遍历每行的每个元素
            if (judge(n)){//判断该位置受否可行
                check(n+1);//可行到下一行在找
            }
            //不可行找到该行的下一个来测试
        }

    }

    private boolean judge(int n){//判断是否可行
        for (int i = 0; i < n; i++) {
            if (array[i]==array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i]) ){//是否在同一列，同一斜线
                return false;
            }
        }
        return true;
    }

    private void print(){//输出可行的方法
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print((array[i]+1)+ " ");
        }
        System.out.println();
    }
}
