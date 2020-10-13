package tree;

public class ThreadedBinaryTree {
    //线索化二叉树

    private HeroNode pre = null;//前一个节点

    //实现线索化功能的二叉树


    //前序
    //后续


    //中序线索化
    public void threadedNodes(HeroNode node){
        if (node == null){
            return;
        }
        //处理前驱节点
        threadedNodes(node.getLeft());

        if(node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //处理后继节点
        if(pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;

        threadedNodes(node.getRight());

    }

    //遍历线索化二叉树
    public void threadedList(HeroNode node){
        while (node != null){
            while (node.getLeftType() == 0){
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();

        }
    }


}
