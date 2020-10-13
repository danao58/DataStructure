package tree.OrderStore;

import tree.OrderStore.ArrBinaryTree;

public class ArrBinaryTreeTest {
    public static void main(String[] args) {
        //顺序遍历
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.postOrder(0);
    }
}
