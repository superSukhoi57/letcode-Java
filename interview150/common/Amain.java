package common;
import verify.*;

import java.util.List;

//包里面就是有很多java的原文件，原文件里的类声明为public才可以在导包时在其他代码里使用！！
/*public class Amain {
    public static void main(String[] args) {
    Solution2 solve=new Solution2();
    int []one={9,9,9,9,9,9,9},two={9,9,9,9};
    ListNode p1=new create().createList(one);
    ListNode p2=new create().createList(two);
    ListNode answer=solve.addTwoNumbers(p1,p2);
    while(answer!=null){
        System.out.println(answer.val+" ");
        answer=answer.next;
    }
    }
}

class create{
    create(){}
    public ListNode createList(int[]arr){
        int len=arr.length;
        ListNode head=new ListNode(arr[0],null);
        ListNode t=head;
        for(int i=1;i<len;i++){
            t.next=new ListNode(arr[i],null);
            t=t.next;
        }
        return head;
    }
}*/
public class Amain{
    public static void main(String[] args) {
        String s="1 + 1";
        Solution224 solve=new Solution224();

        System.out.println(solve.calculate(s));
    }
}