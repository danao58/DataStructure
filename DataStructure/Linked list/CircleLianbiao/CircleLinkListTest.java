package lianbiao.CircleLianbiao;

public class CircleLinkListTest {
    public static void main(String[] args) {//约瑟夫问题
        CircleLinkList circleLinkList=new CircleLinkList();
        circleLinkList.addBoy(5);
        circleLinkList.showBoy();
        circleLinkList.countBoy(1,2,5);
    }
}
