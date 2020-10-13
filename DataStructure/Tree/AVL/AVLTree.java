package tree.AVL;

public class AVLTree {
    private AVLNode root;

    //添加叶子节点
    public void add(AVLNode node){
        if (root == null){
            root = node;
        }else {
            AVLNode before = root;
            addNode(node,before);
        }

       //左旋转
       if (rightHeight() - leftHeight() > 1){
           if (root.getRight() != null && leftHeight(root.getRight()) > rightHeight(root.getRight())){
               rightRotate(root.getRight());
               leftRotate();
           }else {
               leftRotate();
           }
           return;
        }

        //右旋转
        if (leftHeight() - rightHeight() >1){
            if (root.getLeft() != null && rightHeight(root.getLeft()) > leftHeight(root.getLeft())){
                leftRotate(root.getLeft());
                rightRotate();
            }else {
                rightRotate();
            }
            return;
        }
    }

    private void  addNode(AVLNode node,AVLNode before){
        if (node.getValue() < before.getValue()){
            if (before.getLeft() == null){
                before.setLeft(node);
            }else {
                addNode(node,before.getLeft());
            }
        }else {
            if (before.getRight() == null){
                before.setRight(node);
            }else {
                addNode(node,before.getRight());
            }
        }
    }


    //中序遍历
    public void infixOrder(){
        if (root == null){
            System.out.println("空树");
            return;
        }
        infixOrder(root);
    }


    private void infixOrder(AVLNode root){
        if (root.getLeft() != null){
            infixOrder(root.getLeft());
        }
        System.out.println(root);
        if (root.getRight() != null){
            infixOrder(root.getRight());
        }
    }

    //查找要删除的节点
    private AVLNode search(int value){
        return search(value, root);
    }

    private AVLNode search(int value, AVLNode node) {
        if (value == node.getValue()){
            return node;
        }else if (value < node.getValue()){
            if (node.getLeft() == null){
                return null;
            }
            return search(value,node.getLeft());
        }else {
            if (node.getRight() == null){
                return null;
            }
            return search(value,node.getRight());
        }
    }

    //查找要删除的节点的父节点
    private AVLNode searchParent(int value){
        return searchParent(value,root);
    }

    private int delRightTreeMin(AVLNode node){
        AVLNode targe = node;
        while (targe.getLeft() != null){
            targe = targe.getLeft();
        }
        delNode(targe.getValue());
        return targe.getValue();
    }

    private AVLNode searchParent(int value, AVLNode node) {
        if ((node.getLeft() != null && node.getLeft().getValue() == value) ||
                (node.getRight() != null && node.getRight().getValue() == value)){
            return node;
        }else if (value < node.getValue() && node.getLeft() != null){
            return searchParent(value,node.getLeft());
        }else if (value > node.getValue() && node.getRight() != null){
            return searchParent(value,node.getRight());
        }else {
            return null;
        }
    }

    //删除节点
    public void delNode(int value){
        if (root == null){
            System.out.println("树为空");
            return;
        }else if(root.getRight() == null && root.getRight() == null && root.getValue() == value) {
            root = null;
            return;
        }else {
            AVLNode target = search(value);
            AVLNode parent = searchParent(value);
            if (target == null){
                System.out.println("没有该节点");
                return;
            }
            if (target.getLeft() == null && target.getRight() == null){//叶子节点
                if (parent.getRight() != null && parent.getRight().getValue() == value){
                    parent.setRight(null);
                }
                if (parent.getLeft() != null && parent.getLeft().getValue() == value){
                    parent.setLeft(null);
                }
            }else if (target.getLeft() != null && target.getRight() != null){//两颗子树

                int minVal = delRightTreeMin(target.getRight());
                target.setValue(minVal);//从右中找最小的
                //或从左中找最大的
            }else {//一颗子树
                if (target.getLeft() != null){//左子树
                    if (parent !=null){
                        if (parent.getLeft().getValue() == value){//左子节点
                            parent.setLeft(target.getLeft());
                        }else {
                            parent.setRight(target.getLeft());
                        }
                    }else {
                        root = target.getLeft();
                    }
                }else {//右子树
                    if (parent !=null) {
                        if (parent.getLeft().getValue() == value) {//左子节点
                            parent.setLeft(target.getRight());
                        } else {
                            parent.setRight(target.getRight());
                        }
                    }else {
                        root = target.getRight();
                    }
                }
            }

        }


    }


    public int height(){
        return height(root);
    }

    private int height(AVLNode node) {
        return Math.max(node.getLeft() == null ? 0 : height(node.getLeft()),
                node.getRight() == null ? 0 : height(node.getRight())) + 1;
    }

    public int leftHeight(){
      return leftHeight(root);
    }
    private int leftHeight(AVLNode node){
        if (node.getLeft() == null){
            return 0;
        }
        return height(node.getLeft());
    }

    public int rightHeight(){
        return rightHeight(root);
    }
    private int rightHeight(AVLNode node){
        if (node.getRight() == null){
            return 0;
        }
        return height(node.getRight());
    }


   //左旋转
    private void leftRotate(AVLNode node){
        AVLNode avlNode =new AVLNode(node.getValue());
        avlNode.setLeft(node.getLeft());
        avlNode.setRight(node.getRight().getLeft());

        node = node.getRight();
        node.setLeft(avlNode);
        root.setLeft(node);

    }
    //左旋转
    private void leftRotate(){
        AVLNode avlNode =new AVLNode(root.getValue());
        avlNode.setLeft(root.getLeft());
        avlNode.setRight(root.getRight().getLeft());

        root = root.getRight();
        root.setLeft(avlNode);

    }

   //右旋转
    private void rightRotate(AVLNode node){

        AVLNode avlNode = new AVLNode(node.getValue());
        avlNode.setLeft(node.getLeft().getRight());
        avlNode.setRight(node.getRight());

        node = node.getLeft();
        node.setRight(avlNode);
        root.setRight(node);
    }

    //右旋转
    private void rightRotate(){
        AVLNode avlNode = new AVLNode(root.getValue());
        avlNode.setLeft(root.getLeft().getRight());
        avlNode.setRight(root.getRight());

        root = root.getLeft();
        root.setRight(avlNode);
    }



}
