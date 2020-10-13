package NiBoNanBiaoDaSi;

import java.util.Stack;

public class ZhongZHou {
    public static void main(String[] args) {
        String ex ="1+((2+3)*4)-5";
        String s = Transaction(ex);
        System.out.println(s);

    }

    public static String Transaction(String befor){
        Stack<Character> s1 =new Stack<>();//符号
        Stack<Character> s2 =new Stack<>();//数字

        String  s ="";
        int index = 0;
        char ch =' ';

        while (true){
            ch = befor.substring(index,index+1).charAt(0);
            if (ch=='('){
               s1.push(ch);
            }else if (ch==')'){
                while (s1.peek() != '('){
                    s2.push(s1.pop());
                }
                s1.pop();
            }else {
                if (isOper(ch)){
                    if (s1.empty()){
                        s1.push(ch);
                    }else if (priotity(ch) <= priotity(s1.peek())){
                        s2.push(s1.pop());
                        s1.push(ch);
                    }else {
                        s1.push(ch);
                    }
                }else {
                    s2.push(ch);
                }
            }
            index++;
            if (index >=befor.length()){
                s2.push(s1.pop());
                break;
            }
        }

       while (true){
            if (s2.empty()){
                break;
            }
           s = s2.pop()+ " " + s;
       }



        /*char[] chars=new char[s2.size()];
        for (int i = 0; i < chars.length; i++) {
            chars[i]=s2.pop();
        }

        for (int i = chars.length-1; i >=0; i--) {
            s = s + chars[i] + " ";
        }*/

        return s;
    }


    public static boolean isOper(char i){
        return i=='+' || i=='-' || i=='*' || i=='/';
    }


    public static int priotity(int oper) {
        if (oper=='*' || oper=='/'){
            return 2;
        }else if (oper=='+'||oper=='-'){
            return  1;
        }else {
            return 0;
        }
    }
}
