package zhan;

public class Calculator {
    public int priotity(int oper){//运算符优先级
        if(oper == '*' || oper== '/'){
            return 1;
        }else if (oper == '+' || oper=='-'){
            return 0;
        }else {
            return -1;
        }
    }

    public boolean isOper(char val){//是否是运算符
        return val =='*'||val=='/'||val == '+' || val=='-';
    }

    public int cal(int num1,int num2,int oper){//计算过程
        int res = 0;
        switch (oper){
            case '+':
                res =num1 + num2;
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
