package tree.HuffmanTree;

public class Node implements Comparable<Node> {
    int value;//节点权值
    Node left;//左子节点
    Node right;//右子节点

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.value - o.value;
    }
}
