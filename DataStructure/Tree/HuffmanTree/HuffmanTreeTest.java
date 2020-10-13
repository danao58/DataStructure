package tree.HuffmanTree;

public class HuffmanTreeTest {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.preOrder(huffmanTree.createHuffmanTree(arr));

    }
}
