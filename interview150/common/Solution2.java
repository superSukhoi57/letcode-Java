package common;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val=val;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1,ListNode l2) {
        int carry=0,result;
        ListNode p1=l1,p2=l2,answer=null,t=null;
        while(!(p1==null||p2==null)){
            result=p1.val+p2.val+carry;
            if(t==null) {
                t = new ListNode(result % 10 );
                answer=t;
            }else{
                t.next=new ListNode(result%10);
                t=t.next;
            }
            carry=result/10;
            p1=p1.next;
            p2=p2.next;
        }
        if(p1==null&&p2==null&&carry>0){
            t.next=new ListNode(carry);
        }else if(p1==null){
            t.next=new ListNode();
            t.next=p2;

            signal_carry(p2,carry);

        }else{
            t.next=new ListNode();
            t.next=p1;
            signal_carry(p1,carry);
        }
        return answer;
    }
    public void signal_carry(ListNode l,int carry){
        if(l==null)
            return;
        int result=l.val+carry,add;
       do{
            add=result/10;//进位
            l.val=result%10;//个位
            if(l.next!=null){
                l=l.next;
                l.val+=add;
                result=l.val;
            }else
                break;
        } while(result>=10);
        if(result>=10){
            l.val=result%10;
            l.next=new ListNode(result/10);
        }
    }
}
/*
//这里用到int y = l2 == null ? 0 : l2.val;判断节点是否为空，是就直接用0来替代，简化了流程！！


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}


//链接：https://leetcode.cn/problems/add-two-numbers/solutions/7348/hua-jie-suan-fa-2-liang-shu-xiang-jia-by-guanpengc/

 */