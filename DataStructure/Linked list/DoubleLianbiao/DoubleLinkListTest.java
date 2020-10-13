package lianbiao.DoubleLianbiao;

public class DoubleLinkListTest {
    public static void main(String[] args) {
        DoubleLinkList doubleLinkList=new DoubleLinkList();
        HeroNode2 hero1=new HeroNode2(1,"宋江","及时雨");
        HeroNode2 hero2=new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 hero5=new HeroNode2(1,"宋江","ttf");
        HeroNode2 hero3=new HeroNode2(3,"吴用","智多星");
        HeroNode2 hero4=new HeroNode2(4,"林冲","豹子头");

        doubleLinkList.addByOrder(hero4);
        doubleLinkList.addByOrder(hero3);
        doubleLinkList.addByOrder(hero1);
        doubleLinkList.addByOrder(hero3);
        doubleLinkList.addByOrder(hero2);



        //按编号添加数据

       // doubleLinkList.update(hero5);

       doubleLinkList.del(2);

        doubleLinkList.show();
    }
}
