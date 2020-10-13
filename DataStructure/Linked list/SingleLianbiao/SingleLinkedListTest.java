package lianbiao.SingleLianbiao;

import lianbiao.SingleLianbiao.HeroNode;
import lianbiao.SingleLianbiao.SingleLinkedList;

public class SingleLinkedListTest {
    public static void main(String[] args) {
        HeroNode hero1=new HeroNode(1,"宋江","及时雨");
        HeroNode hero2=new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero5=new HeroNode(1,"宋江","及时雨");
        HeroNode hero3=new HeroNode(3,"吴用","智多星");
        HeroNode hero4=new HeroNode(4,"林冲","豹子头");
        HeroNode hero6=new HeroNode(1,"但澳","爸爸");
        HeroNode hero7=new HeroNode(7,"但澳","爸爸");

        SingleLinkedList singleLS=new SingleLinkedList();
        singleLS.addByOrder(hero4);
        singleLS.addByOrder(hero1);
        singleLS.addByOrder(hero5);
        singleLS.addByOrder(hero3);
        singleLS.addByOrder(hero2);

        singleLS.reverseHead(singleLS.getHead());

        //singleLS.reverseHead(singleLS.getHead());

        /*System.out.println(singleLS.getLength(singleLS.getHead()));

        System.out.println("================");

        System.out.println(singleLS.findLastIndexNode(singleLS.getHead(),3));

        System.out.println("===============");*/

        //合并两个有序的单链表，合并之后的链表依然有序



        singleLS.show();

        System.out.println("===========");

        singleLS.reversePrint(singleLS.getHead());

      /*  singleLS.update(hero7);

        singleLS.update(hero6);

        singleLS.show();
        System.out.println("===============");
        singleLS.del(1);
        singleLS.del(4);
        singleLS.show();*/
    }
}
