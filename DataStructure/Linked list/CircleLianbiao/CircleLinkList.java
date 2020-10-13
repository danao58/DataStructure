package lianbiao.CircleLianbiao;

public class CircleLinkList {
    private Boy first = null;//第一个节点

    public void addBoy(int num){//添加队列
         if (num<1){
             System.out.println("值不正确");
             return;
         }

         Boy curBoy = null;//定位节点

        for (int i = 1; i < num+1; i++) {
            Boy boy = new Boy(i);
            if (i==1){//第一个添加的(避免空指针异常)
                first=boy;
                first.setNext(first);
                curBoy=first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }

        }
    }

    public void showBoy(){//展示队列
        if (first==null){
            System.out.println("链表为空");
            return;
        }
        Boy curBoy = first;
        while (true){
            System.out.println("小孩的编号为"+curBoy.getNo());
            if (curBoy.getNext()==first){//说明已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext();//curBoy后移
        }
    }
    /*
    * startNo从第几个小孩开始数
    * countNum数几下
    * nums最初有多少小孩在圈中
    * */
    public void countBoy(int startNo,int countNum,int nums){//出圈
        if (first==null||startNo<1||startNo>nums){
            System.out.println("输入参数有误，请重新输入");
            return;
        }

        Boy helper = first;//用于数几下的指针

        while (true){//指向环形链表的最后节点
            if (helper.getNext()==first){
                break;
            }
            helper=helper.getNext();
        }

        for (int i = 0; i < startNo - 1; i++) {//让f和h到达从第几个开数的位置，及将开数位置定为f，它的后一个为h
            first=first.getNext();
            helper=helper.getNext();
        }

        while (true){//出圈运算
            if (helper==first){//全部出圈完
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {//让f和h到达【数cN】的位置
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.println(first.getNo()+"小孩出圈");
            first = first.getNext();//连接到【要出圈的数的位置】的下一个【头】
            helper.setNext(first);//连接到【改变后f】的前一个【尾】
        }

        System.out.println("最后留在圈中的小孩编号"+first.getNo());

    }

}
