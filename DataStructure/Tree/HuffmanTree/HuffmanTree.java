package tree.HuffmanTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

    //创建赫夫曼树
   public Node createHuffmanTree(int[] arr){
       List<Node> nodes = new ArrayList<>();
       for (int value : arr){
           nodes.add(new Node(value));
       }
       while (nodes.size() > 1){
           Collections.sort(nodes);//从小到大排序

           Node leftNode = nodes.get(0);
           Node rightNode = nodes.get(1);//获取较小的两个元素

           Node parent = new Node(leftNode.value + rightNode.value);//最小的两个相加，得到一个值
           parent.left = leftNode;//左节点
           parent.right = rightNode;//右节点

           nodes.remove(leftNode);//移除之前的
           nodes.remove(rightNode);

           nodes.add(parent);//将新的加入进去
       }
       return  nodes.get(0);
   }


   //前序遍历
   public void preOrder(Node root){
       System.out.println(root);
       if (root.left != null){
           preOrder(root.left);
       }
       if (root.right !=null){
           preOrder(root.right);
       }

   }



}
