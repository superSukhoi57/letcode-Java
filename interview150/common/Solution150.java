package common;
import java.util.Stack;
public class Solution150 {
    public int evalRPN(String[] tokens) {
        int len = tokens.length, i;
        int one, two;
        Stack<Integer> number = new Stack<>();
        char ch;
        String str;
        for (i = 0; i < len; i++) {
            ch = tokens[i].charAt(0);
            str=tokens[i];
            if (!str.equals("+")&&!str.equals("-")&&!str.equals("*")&&!str.equals("/")) {
                    number.push(Integer.parseInt(str));//将字符转化为数字。
                 }
            else {
                one = number.pop();
                two = number.pop();
                switch (ch) {
                    case '+':
                        number.push(one + two);
                        break;
                    case '-':
                        number.push(two - one);
                        break;
                    case '*':
                        number.push(one * two);
                        break;
                    case '/':
                        number.push(two / one);
                        break;
                }
            }
        }
            return number.pop();
        }
    }

