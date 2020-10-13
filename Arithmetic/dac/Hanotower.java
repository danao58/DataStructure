package dac;

public class Hanotower {
    public static void main(String[] args) {
        hanoiTower(5,'A','B','C');
    }

    public static void hanoiTower(int num,char a,char b,char c){//汉诺塔
        if (num == 1){
            System.out.println("第一个盘从"+a+"->"+c);
        }else {
            hanoiTower(num - 1,a,c,b);
            System.out.println("第"+num+"个盘从"+a+ "->" +c);
            hanoiTower(num - 1,b,a,c);
        }
    }

}
