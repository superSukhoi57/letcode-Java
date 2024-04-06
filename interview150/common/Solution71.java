package common;
import java.util.Stack;
public class Solution71 {
    public String simplifyPath(String path) {
        int len=path.length(),start=1,end=1;
        String str;
        Stack<String>arr=new Stack<>();
        //前面可能不止一个/，所以要除去前面多余的/
        while(end<len&&path.charAt(end)=='/')
            end++;
        start=end;
        while(end<len){
            //向后找到不为/的位置，因为substring是[，)做闭右开的所以！！
            while(end<len&&path.charAt(end)!='/'){
                end++;
            }
            //substring[，）很重要！！！
            if(end>len)
                break;
            str=path.substring(start,end);
            if(str.equals("..")){
                if(!arr.isEmpty())
                    arr.pop();

            }else if(!str.equals(".")){
                //不等于.也很重要，要不然等于.也加进去就会错误！！！
                arr.push(str);
            }

           while(end<len&&path.charAt(end)=='/')
               end++;
           start=end;
        }
        Stack<String>mid=new Stack<>();
        while(!arr.isEmpty()){
            mid.push(arr.pop());
        }
        String answer="/";
        while(!mid.isEmpty()){
            if(mid.size()!=1){
                answer+=(mid.pop()+"/");
            }else
                answer+=mid.pop();
        }
        return answer;
    }
}
