package tree;

import org.junit.Test;

public class BinaryTreeTest {
    @Test
    public void TreeTest(){
        BinaryTree binaryTree = new BinaryTree();
        HeroNode heroNode1 = new HeroNode(1,"松江");
        HeroNode heroNode2 = new HeroNode(3,"长江");
        HeroNode heroNode3 = new HeroNode(8,"黄河");
        HeroNode heroNode4 = new HeroNode(10,"清白江");
        HeroNode heroNode5 = new HeroNode(6,"内江");
        HeroNode heroNode6 = new HeroNode(14,"雅鲁藏布江");


        heroNode1.setLeft(heroNode2);
        heroNode1.setRight(heroNode5);
        heroNode2.setLeft(heroNode3);
        heroNode2.setRight(heroNode4);
        heroNode5.setLeft(heroNode6);

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.threadedNodes(heroNode1);

        threadedBinaryTree.threadedList(heroNode1);


        //后序遍历
        //binaryTree.postOrder(heroNode1);

        //中序遍历
        //binaryTree.infixOrder(heroNode1);

        //前序遍历
       /* binaryTree.preOrder(heroNode1);
        binaryTree.delNode(1,heroNode1);
        System.out.println("======================");
        binaryTree.preOrder(heroNode1);*/

        //System.out.println(binaryTree.postOrderSearch(15,heroNode1));



    }
}
