package zhan;

public class Calculator {//优先级以及两数之间的运算

    public int priotity(int oper){//运算符优先级

        if(oper == '*' || oper== '/'){//先乘除

            return 1;

        }else if (oper == '+' || oper=='-'){//后加减

            return 0;

        }else {

            return -1;
        }
    }

    //判断是否未运算符
    public boolean isOper(char val){//是否是运算符
        return val =='*'||val=='/'||val == '+' || val=='-';
    }

    //运算
    public int cal(int num1,int num2,int oper){

        int res = 0;

        switch (oper){

            case '+':

                res = num1 + num2;

                break;

            case '-':

                res = num2 - num1;

                break;

            case '*':

                res = num1 * num2;

                break;

            case '/':

                res = num2 / num1;

        }

        return res;
    }

}
