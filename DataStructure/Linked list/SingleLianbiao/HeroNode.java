package lianbiao.SingleLianbiao;

public class HeroNode {//链表的元素定义
    //链表中的值
    public int no;//编号
    public String name;//名称
    public String nickname;//别名

    public HeroNode next;//下一个对象

    //赋值
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
