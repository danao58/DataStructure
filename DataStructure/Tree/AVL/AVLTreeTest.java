package tree.AVL;

public class AVLTreeTest {
    public static void main(String[] args) {
        //平衡二叉树
        AVLTree avlTree = new AVLTree();
        //int[] arr = {4,3,6,5,7,8};//左旋转用例
        //int[] arr = {10,12,8,9,7,6};//右旋转用例
        int[] arr = {10,11,7,6,8,9};//双旋转
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new AVLNode(arr[i]));
        }


        int height = avlTree.height();
        int leftHeight = avlTree.leftHeight();
        int rightHeight = avlTree.rightHeight();


        System.out.println(height);
        System.out.println(leftHeight);
        System.out.println(rightHeight);

    }
}
