package tree.HuffmanCode;

import java.util.*;

public class HuffmanCode {

    //生成赫夫曼编码集合
    private List<HuffmanCodeNode> getNodes(byte[] bytes){


        List<HuffmanCodeNode> nodes = new ArrayList<>();

        Map<Byte,Integer> counts = new HashMap<>();
        //统计字母出现个数
        for (Byte b:bytes){
            Integer count = counts.get(b);
            if (count == null){
                counts.put(b,1);
            }else {
                counts.put(b,count + 1);
            }
        }
        //遍历nodes
        for (Map.Entry<Byte,Integer> entry : counts.entrySet()){
            nodes.add(new HuffmanCodeNode(entry.getKey(),entry.getValue()));
        }

        return nodes;

    }

    //将该编码表转为赫夫曼树
    private HuffmanCodeNode createHuffmanTree(List<HuffmanCodeNode> nodes){
        while (nodes.size()>1){
            Collections.sort(nodes);
            HuffmanCodeNode left = nodes.get(0);
            HuffmanCodeNode right = nodes.get(1);

            HuffmanCodeNode x = new HuffmanCodeNode(null,left.getWeight() + right.getWeight());

            x.setLeft(left);
            x.setRight(right);

            nodes.add(x);
            nodes.remove(left);
            nodes.remove(right);
        }
        return nodes.get(0);
    }

    //前序遍历赫夫曼树
    private void preTree(HuffmanCodeNode root){
        System.out.println(root);
        if (root.getLeft() != null){
            preTree(root.getLeft());
        }
        if (root.getRight() != null){
            preTree(root.getRight());
        }
    }

    Map<Byte,String> huffmanCodes = new HashMap<>();//生成后的赫夫曼编码


    //将传入的赫夫曼树转为赫夫曼编码表
    private Map<Byte,String> transferCode(HuffmanCodeNode root){
        StringBuilder stringBuilder = new StringBuilder();
        getCodes(root,"",stringBuilder);
        return huffmanCodes;
    }

    //生成赫夫曼树对应的赫夫曼编码
    private void getCodes(HuffmanCodeNode root,String code,StringBuilder builder){
        StringBuilder stringBuilder2 = new StringBuilder(builder);
        stringBuilder2.append(code);
        if(root != null){//非最后一个节点
            if (root.getDate() == null){//非叶子节点
                getCodes(root.getLeft(),"0",stringBuilder2);
                getCodes(root.getRight(),"1",stringBuilder2);
            }else {
                huffmanCodes.put(root.getDate(),stringBuilder2.toString());
            }
        }
    }

    //将赫夫曼编码进行压缩
    public byte[] zip(byte[] bytes){

        transferCode(createHuffmanTree(getNodes(bytes)));

        StringBuilder stringBuilder = new StringBuilder();

        for (byte b:bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }
        int len =(stringBuilder.length() + 7)/8;

        byte[] by = new byte[len];

        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i+=8) {
            if (i+8 > stringBuilder.length()){
                by[index] = (byte) Integer.parseInt(stringBuilder.substring(i),2);
            }else {
                by[index] = (byte) Integer.parseInt(stringBuilder.substring(i,i+8),2);
            }
            index++;
        }
        return by;
    }

    public byte[] decode(byte[] huffmanByte){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanByte.length; i++) {
            boolean falg = (i != huffmanByte.length -1);
            stringBuilder.append(byteToBitString(falg,huffmanByte[i]));
        }
        Map<String, Byte> map = new HashMap<>();
        for (byte k:huffmanCodes.keySet()) {
            map.put(huffmanCodes.get(k),k);
        }
        List<Byte> list = new ArrayList<>();


        int j = 1;
        int r = 0;
        while (j <= stringBuilder.length()) {
            String s = stringBuilder.substring(r,j);
            if (map.containsKey(s)){
                list.add(map.get(s));
                r=j;
                j++;
            }else {
                j++;
            }
        }
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }


    private  String byteToBitString(boolean flag,byte b){
        int temp = b;
        if (flag){
            temp |= 256;//补高位
        }
        String str = Integer.toBinaryString(temp);
        if (flag){
           return str.substring(str.length() - 8);
        }
            return str;

    }


}
