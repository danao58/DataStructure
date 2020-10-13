package tree.HuffmanCode;

public class HuffmanCodeNode implements Comparable<HuffmanCodeNode>{
    private Byte Date;
    private int weight;
    private HuffmanCodeNode left;
    private HuffmanCodeNode right;

    public HuffmanCodeNode(Byte date, int weight) {
        Date = date;
        this.weight = weight;
    }



    public Byte getDate() {
        return Date;
    }

    public void setDate(Byte date) {
        Date = date;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public HuffmanCodeNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanCodeNode left) {
        this.left = left;
    }

    public HuffmanCodeNode getRight() {
        return right;
    }

    public void setRight(HuffmanCodeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HuffmanCodeNode{" +
                "Date=" + Date +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(HuffmanCodeNode o) {
        return this.weight - o.weight;//从小到大排序
    }
}
