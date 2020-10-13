package tree.OrderStore;

public class ArrBinaryTree {
    //顺序遍历
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //前序遍历
    public void preOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        System.out.println(arr[index]);
        if (2*index + 1 < arr.length){
            preOrder(2*index +1);
        }
        if (2*index + 2< arr.length){
            preOrder(2*index +2);
        }
    }

    //中序遍历
    public void infixOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        if (2*index + 1 < arr.length){
            preOrder(2*index +1);
        }
        System.out.println(arr[index]);
        if (2*index + 2< arr.length){
            preOrder(2*index +2);
        }
    }
    //后序遍历

    public void postOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        if (2*index + 1 < arr.length){
            preOrder(2*index +1);
        }
        if (2*index + 2< arr.length){
            preOrder(2*index +2);
        }
        System.out.println(arr[index]);
    }
}
