package tree;

public class BinaryTree {
    //前序遍历
    public void preOrder(HeroNode heroNode){
        System.out.println(heroNode);//先输出父节点
        if(heroNode.getLeft() != null){
            preOrder(heroNode.getLeft());
        }
        if(heroNode.getRight() != null){
            preOrder(heroNode.getRight());
        }
    }

    //中序遍历
    public void infixOrder(HeroNode heroNode){
        if(heroNode.getLeft() != null){
            infixOrder(heroNode.getLeft());
        }
        System.out.println(heroNode);
        if(heroNode.getRight() != null){
            infixOrder(heroNode.getRight());
        }
    }

    //后序遍历
    public void postOrder(HeroNode heroNode){
        if(heroNode.getLeft() != null){
            postOrder(heroNode.getLeft());
        }
        if(heroNode.getRight() != null){
            postOrder(heroNode.getRight());
        }
        System.out.println(heroNode);
    }

    //前序查找
    public HeroNode preOrderSearch(int no,HeroNode heroNode){

        if (heroNode.getNo() == no) {
            return heroNode;
        }
        HeroNode result = null;
        if(heroNode.getLeft() != null) {
           result = preOrderSearch(no, heroNode.getLeft());
        }
        if (result != null){
            return result;
        }
        if (heroNode.getRight() != null) {
            result = preOrderSearch(no, heroNode.getRight());
        }

        return result;
    }

    //中序查找
    public HeroNode infixOrderSearch(int no,HeroNode heroNode){

        HeroNode result = null;
        if(heroNode.getLeft() != null) {
            result = preOrderSearch(no, heroNode.getLeft());
        }
        if (result != null){
            return result;
        }
        if (heroNode.getNo() == no) {
            return heroNode;
        }
        if (heroNode.getRight() != null) {
            result = preOrderSearch(no, heroNode.getRight());
        }
        return result;
    }

    //后序查找
    public HeroNode postOrderSearch(int no,HeroNode heroNode){

        HeroNode result = null;
        if(heroNode.getLeft() != null) {
            result = preOrderSearch(no, heroNode.getLeft());
        }
        if (result != null){
            return result;
        }
        if (heroNode.getRight() != null) {
            result = preOrderSearch(no, heroNode.getRight());
        }
        if (result != null){
            return result;
        }
        if (heroNode.getNo() == no) {
            return heroNode;
        }
        return result;
    }


    /*
    * 递归删除结点
    * 如果删除节点是叶子节点，则删除该节点
    * 如果删除节点是非叶子节点，则删除该树
    * */
    public void delNode(int no,HeroNode heroNode){
        if (heroNode.getNo() == no){
            heroNode = null;
            return;
        }
        if(heroNode.getLeft() != null && heroNode.getLeft().getNo() == no) {
            heroNode.setLeft(null);
            return;
        }
        if (heroNode.getRight() != null && heroNode.getRight().getNo() == no) {
            heroNode.setRight(null);
            return;
        }
        if (heroNode.getLeft() != null){
            delNode(no,heroNode.getLeft());
        }
        if (heroNode.getRight() != null){
            delNode(no,heroNode.getRight());
        }
        /*
         * 递归删除结点
         * 如果删除节点是叶子节点，则删除该节点
         * 如果删除节点是非叶子节点，则将该节点的左节点连接到上个节点
        */

    }



}
