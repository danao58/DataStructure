package NiBoNanBiaoDaSi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //(3+4)*5-6 -> 3 4 + 5 * 6 -(逆波兰表达式)

        String suffixExpression="3 4 + 5 * 6 - ";

        List<String> list = getListString(suffixExpression);

        int res = calculate(list);

        System.out.println(res);


    }

    public static List<String> getListString(String suffixExpression){//将表达式转换为Arraylist
       String[] splits = suffixExpression.split(" ");
       List<String> list = new ArrayList<>();
        for (String i:splits) {
            list.add(i);
        }
        return list;
    }

    public static int calculate(List<String> ls){//计算
        Stack<String> stack = new Stack<>();
        for (String item:ls) {
            if (item.matches("\\d+")){//判断是否是一个数(正则表达式)
                stack.push(item);
            }else {
               int num1 = Integer.parseInt(stack.pop());
               int num2 = Integer.parseInt(stack.pop());
               int res = 0;
               if (item.equals("+")){
                   res = num1 + num2;
               }else if (item.equals("-")){
                   res =num2 - num1;
               }else if (item.equals("*")){
                   res = num1 * num2;
               }else if (item.equals("/")){
                   res = num2 / num1;
               }else {
                   throw new RuntimeException();
               }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }

}
