package tree.BinarySortTree;

public class BinarySortTree {

    private BinaryNode root;


    //添加叶子节点
    public void add(BinaryNode node){
        if (root == null){
            root = node;
            return;
        }else {
            BinaryNode before = root;
            addNode(node,before);
        }
    }

    private void  addNode(BinaryNode node,BinaryNode before){
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

    private void infixOrder(BinaryNode root){
        if (root.getLeft() != null){
            infixOrder(root.getLeft());
        }
        System.out.println(root);
        if (root.getRight() != null){
            infixOrder(root.getRight());
        }
    }

    //查找要删除的节点
    private BinaryNode search(int value){
       return search(value, root);
    }

    private BinaryNode search(int value, BinaryNode node) {
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
    private BinaryNode searchParent(int value){
        return searchParent(value,root);
    }

    private int delRightTreeMin(BinaryNode node){
        BinaryNode targe = node;
        while (targe.getLeft() != null){
            targe = targe.getLeft();
        }
        delNode(targe.getValue());
        return targe.getValue();
    }

    private BinaryNode searchParent(int value, BinaryNode node) {
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
                BinaryNode target = search(value);
                BinaryNode parent = searchParent(value);
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


}
