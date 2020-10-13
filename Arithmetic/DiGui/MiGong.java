package DiGui;

public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];//地图

        for (int i = 0; i < 7; i++) {//设置上下两边为1
            map[0][i]=1;
            map[7][i]=1;
        }

        for (int i = 0; i < 8; i++) {//设置左右两边为1
            map[i][0]=1;
            map[i][6]=1;
        }
        //设置挡板
        map[3][1]=1;
        map[3][2]=1;
        /*
        * 1 1 1 1 1 1 1
        * 1           1
        * 1           1
        * 1 1 1       1
        * 1           1
        * 1           1
        * 1           1
        * 1 1 1 1 1 1 1
        * */

        setWay(map,1,1);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        //如何求最短路径：和策略有关
        /*
        * 1 1 1 1 1 1 1
        * 1 2 0 0 0 0 1
        * 1 2 2 2 0 0 1
        * 1 1 1 2 0 0 1
        * 1 0 0 2 0 0 1
        * 1 0 0 2 0 0 1
        * 1 0 0 2 2 2 1
        * 1 1 1 1 1 1 1
        * */
    }

    /*
    * map地图
    * i开始位置
    * j
    * 找到ture，找不到false
    * 1为墙，2可以走，3为已走过走不通
    * 走迷宫策略下->右->上->左
    * */
    public static boolean setWay(int[][] map,int i ,int j){
        if(map[6][5]==2){
            return true;
        }else {
            if (map[i][j]==0){
                map[i][j]=2;
                if (setWay(map,i+1,j)){
                    return true;
                }else if (setWay(map,i,j+1)){
                    return true;
                }else if(setWay(map,i-1,j)){
                    return true;
                }else if (setWay(map,i,j-1)){
                    return true;
                }else {
                    map[i][j]=3;
                    return false;
                }
            }else {
                return false;
            }
        }


    }


}
