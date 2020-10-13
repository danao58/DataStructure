package lianbiao.DoubleLianbiao;

public class DoubleLinkList {

     private  HeroNode2 head = new HeroNode2(0,"","");

    public void add(HeroNode2 heroNode2){
        HeroNode2 temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=heroNode2;
        heroNode2.pre=temp;
    }

    public void addByOrder(HeroNode2 heroNode2){//有序的链表
        HeroNode2 temp = head;//将头节点赋值给temp
        boolean flag = false;//用于判断no是否重复
        while (true){
            if (temp.next==null){//说明已经是最后一个节点
                break;
            }
            if (temp.next.no>heroNode2.no){//【后一个节点】是否比【当前要插入的节点】的no要大
                break;
            }else if (temp.next.no==heroNode2.no){//【后一个节点】是否和【当前要插入的节点】no一样
                flag=true;
                break;
            }
            temp = temp.next;//转到下一个节点
        }
        if (flag){//重复时
            System.out.println("准备插入的英雄编号已存在");
        }else {
            //1->3,插入2
            //1->3,2->3
            //1->2->3,将2覆盖3


            heroNode2.next = temp.next;
            if (temp.next!=null){
                temp.next.pre=heroNode2;
            }
            temp.next=heroNode2;
            heroNode2.pre =temp;



        }

    }






    public void update(HeroNode2 heroNode2){
        HeroNode2 temp = head;
        if (temp.next==null){
            System.out.println("链表为空");
            return;
        }
        boolean flag=false;
        while (true){
            if (temp.next==null){
                break;
            }
            if (temp.next.no==heroNode2.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.next.name=heroNode2.name;
            temp.next.nickname=heroNode2.nickname;
        }else {
            System.out.println("没有找到编号为"+heroNode2.no+"的节点");
        }
    }

    public void del(int no){
        HeroNode2 temp = head.next;
        if (temp==null){
            return;
        }
        boolean flag=false;
        while (true){
            if (temp==null){
                break;
            }
            if (temp.no==no){
                flag=true;
                break;
            }
            temp= temp.next;
        }

        if (flag){
            temp.pre.next=temp.next;
            if (temp.next!=null){
                temp.next.pre=temp.pre;
            }

        }else {
            System.out.println("要删除的节点不存在");
        }

    }

    public void show(){
        HeroNode2 temp =head;
        if (temp.next==null){
            System.out.println("链表为空");
        }
        while (temp.next!=null){
            System.out.println(temp.next);
            temp=temp.next;
        }
    }





}
