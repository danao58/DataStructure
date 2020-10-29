package lianbiao.SingleLianbiao;

import lianbiao.SingleLianbiao.HeroNode;

import java.util.Stack;

public class SingleLinkedList {//单向链表

    //头节点(固定)
    private HeroNode head = new HeroNode(0,"","");


    public void addByOrder(HeroNode heroNode){//有序添加节点

        HeroNode temp = head;//将头节点赋值给temp

        boolean flag = false;//用于判断no是否重复

            while (true){

                if (temp.next==null){//说明已经是最后一个节点
                    break;
                }
                if (temp.next.no > heroNode.no){//【后一个节点】是否比【当前要插入的节点】的no要大
                    break;
                }else if (temp.next.no==heroNode.no){//【后一个节点】是否和【当前要插入的节点】no一样
                    flag = true;
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

                heroNode.next = temp.next;//将【后一个节点】传到【当前插入节点】的后面

                temp.next = heroNode;//将【当前插入的节点】插入到【后一个节点】
            }
        }

        public void add(HeroNode heroNode){//添加节点

            HeroNode temp = head;//将头节点赋值给temp

            while (true){

                if (temp.next==null){
                    break;//找到最后节点退出循环
                }

                temp = temp.next;//没有找到最后节点，将temp后移一次

            }
            temp.next = heroNode;//循环完成到达最后一个节点，为最后一个节点赋值为要添加的值
        }

        public void update(HeroNode newHeroNode){//修改节点

            if (head.next==null){//判断是否为空链表
                System.out.println("链表为空");
                return;
            }

            HeroNode temp = head.next;//从第一个开始

            boolean flag = false;

            while (true){
                if (temp == null){//已经遍历完
                    break;
                }
                if (temp.no == newHeroNode.no){//编号是否相同
                    flag = true;
                    break;
                }
                temp = temp.next;//转到下一个
            }
            if (flag){
                temp.name = newHeroNode.name;//把传入的数据赋值给当前节点
                temp.nickname = newHeroNode.nickname;
            }else {
                System.out.println("未找到编号为"+newHeroNode.no+"的节点");
            }

        }

        //返回头节点
        public HeroNode getHead(){//获取头节点
            return head;
        }

        public void del(int no){//按编号，删除节点

            HeroNode temp = head;//定位为到链表的头部

            boolean flag = false;//表示是否找到

            while (true){
                if (temp.next == null){//遍历完
                    break;
                }
                if (temp.next.no == no){//找到
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag){
                temp.next = temp.next.next;//1-2-3->1-3
            }else {
                System.out.println("未找到节点");
            }

        }

        public int getLength(HeroNode head){//查看节点个数
            if(head.next == null){
                System.out.println("链表为空");
                return 0;
            }

            HeroNode temp = head.next;

            int count = 0;//计数

            while (temp != null){
                count++;
                temp = temp.next;
            }

            return count;
        }

        public HeroNode findLastIndexNode(HeroNode head,int index){//得到倒数第index个节点
            if (head.next == null){
                return null;
            }
            int size = getLength(head);
            if(index <= 0 || index > size){
                return null;
            }
            HeroNode temp = head.next;
            for (int i = 0; i < size - index; i++) {
                temp = temp.next;
            }
            return temp;
        }

        public void reverseHead(HeroNode head){

            HeroNode temp = head.next;

            if (temp == null || temp.next == null){
                return ;
            }

            HeroNode next = null;

            HeroNode rhead =new HeroNode(0,"","");



            while (temp!=null){
                next = temp.next;//暂时保存当前节点的下一个节点
                temp.next = rhead.next;//将temp的下一个节点指向新链表上
                rhead.next = temp;//将temp连接到新链表上
                temp = next;//让temp后移
                   // retemp =retemp.next;
                   // retemp = temp;
                }

                head.next = rhead.next;//将head节点连接到rhead节点后的一个节点
            }

        public void reversePrint(HeroNode head){//反向打印输出
            if (head.next == null){
                return;
            }
            Stack<HeroNode> stack = new Stack<HeroNode>();
            HeroNode temp = head.next;
            while (temp != null){
                stack.push(temp);
                temp = temp.next;
            }

            while (stack.size()>0){
                System.out.println(stack.pop());
            }
        }

        public void show(){
            //判断链表是否为空
            if (head.next == null){
                System.out.println("链表为空");
                return;
            }

            HeroNode temp = head.next;//定位到头指针的下一个节点

            while (true){

                if (temp == null){
                    break;//找到最后节点退出循环
                }

                System.out.println(temp);//输出节点中的数据

                temp = temp.next;//转移到下一个节点
            }

        }

    }




