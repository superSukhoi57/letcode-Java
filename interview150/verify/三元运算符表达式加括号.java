package verify;

public class 三元运算符表达式加括号 {
    public static void main(String[] args) {
        int big=19,small=1,x,y;
        x=1+big>small?big:small;
        y=1+(big>small?big:small);
        System.out.println("1+big>small?big:small = "+x);
        System.out.println("1+(big>small?big:small) = "+y);
    }
}
/*
结果为：
1+big>small?big:small = 19
1+(big>small?big:small) = 20
TODO：综上所述，1+big>small?big:small会先算加法，在三元运算符，三元运算符的优先级低！
 */