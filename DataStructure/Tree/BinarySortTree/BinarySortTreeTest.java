package tree.BinarySortTree;

public class BinarySortTreeTest {


    public static void main(String[] args) {
        //二叉排序树
        BinarySortTree binarySortTree = new BinarySortTree();

        int[] arr = {7,3,10,12,5,1,9,2};
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new BinaryNode(arr[i]));
        }
        binarySortTree.infixOrder();
        System.out.println("===============");
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.delNode(arr[i]);
        }
        binarySortTree.infixOrder();
    }
}
