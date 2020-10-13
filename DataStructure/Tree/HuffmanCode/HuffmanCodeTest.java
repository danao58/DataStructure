package tree.HuffmanCode;

import java.util.List;
import java.util.Map;

public class HuffmanCodeTest {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";

        byte[] contentBytes = content.getBytes();

        System.out.println("压缩前的长度" + contentBytes.length);

        HuffmanCode huffmanCode = new HuffmanCode();
        byte[] zip = huffmanCode.zip(contentBytes);

        System.out.println("压缩后");
        for (byte b:zip) {
            System.out.println(b);
        }
        System.out.println("=============");

        System.out.println("解压后");
        byte[] decode = huffmanCode.decode(zip);

        System.out.println("原来的字符串为："+ new String(decode));

        //huffmanCode.preTree(root);





    }


}
