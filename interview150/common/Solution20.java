package common;
import java.util.Stack;
/*
public class Solution20 {
    public boolean isValid(String s) {
        int len=s.length(),i,j;
        char ch;
        Stack<Character>y=new Stack<>(),h=new Stack<>(),f=new Stack<>();
        for(i=0;i<len;i++){
            ch=s.charAt(i);
            if(ch=='('){
                y.push(ch);
            }else if(ch=='{'){
                h.push(ch);
            }else if(ch=='['){
                f.push(ch);
            }

            if(ch==')'){
                if(!y.isEmpty()&&y.peek()=='(')
                    y.pop();
                else
                    return false;
            }else if(ch=='}'){
                if(!h.isEmpty()&&h.peek()=='{')
                    h.pop();
                else
                    return false;
            }else if(ch==']'){
                if(!f.isEmpty()&&f.peek()=='[')
                    f.pop();
                else
                    return false;
            }
        }
        if(y.isEmpty()&&h.isEmpty()&&f.isEmpty())
            return true;
        else
            return false;

    }
}
*/


class Solution20{
    public boolean isValid(String s) {
        int len=s.length(),i;
        char ch;
        Stack<Character>st=new Stack<>();
        for(i=0;i<len;i++){
            ch=s.charAt(i);
            if(ch=='('||ch=='{'||ch=='[')
                st.push(ch);
            else{
                if(st.isEmpty())
                    return false;
                if(ch==')'){
                    if(st.peek()=='(')
                        st.pop();
                    else
                        return false;
                }else if(ch=='}'){
                    if(st.peek()=='{')
                        st.pop();
                    else
                        return false;
                }else if(ch==']'){
                    if(st.peek()=='[')
                        st.pop();
                    else
                        return false;
                }
            }
        }
        if(st.isEmpty())
            return true;
        else
            return false;
    }
}
