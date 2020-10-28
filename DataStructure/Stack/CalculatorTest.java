package zhan;

import java.util.Calendar;

public class CalculatorTest {
    public static void main(String[] args) {

        String expression = "177+3*6-4";
        calculator(expression);

    }

    public static void calculator(String expression) {//使用栈做计算器


        Calculator calculator =new Calculator();

        //需要使用ArrayStack类

        ArrayStack numStack = new ArrayStack(10);//数据栈

        ArrayStack operStack =new ArrayStack(10);//运算符栈

        //加入小括号：逆波兰表达式

        int index = 0;//定位指针

        int num1 = 0;//栈中最后一个数据

        int num2 = 0;//栈中倒数第二个数据

        int oper = 0;//栈中最后一个运算符

        int res = 0;//计算后得到的值

        String keepNum="";//值的寄存处

        char ch = ' ';//取出字符的寄存处

        while (true){// * /的运算与数值的存入

            ch = expression.substring(index,index + 1).charAt(0);//取出当前字符

            if (calculator.isOper(ch)){//是否是操作符

                numStack.push(Integer.parseInt(keepNum));//不是数字了将所寄存的数添加到堆中

                keepNum="";//还原寄存处

                if (operStack.isEmpty()){//操作符栈是否为空

                    operStack.push(ch);//为空，加入运算符栈中

                }else {

                    if (calculator.priotity(ch) <= calculator.priotity(operStack.StackTop())){

                        //存入的操作符是否小于等于已存在的操作符
                        num1 = numStack.pop();

                        num2 = numStack.pop();

                        oper = operStack.pop();

                        res = calculator.cal(num1,num2,oper);

                        numStack.push(res);//存入计算后的值

                        operStack.push(ch);//存入当钱读取的符号

                    }else {

                        operStack.push(ch);//存入当钱读取的符号
                    }
                }
            }else {

                keepNum += ch;//将当前读取的存入寄存数据中
            }

            index++;//定位字符前进

            if (index >= expression.length()){//读取是否完成

                numStack.push(Integer.parseInt(keepNum));//读到最后一个添加最后一个

                keepNum="";

                break;
            }
        }

        while (true){//+-的运算

            if (operStack.isEmpty()){

                break;

            }
            num1 = numStack.pop();

            num2 = numStack.pop();

            oper = operStack.pop();

            res = calculator.cal(num1,num2,oper);

            numStack.push(res);

        }

        System.out.println(expression+"="+numStack.pop());
    }


}
