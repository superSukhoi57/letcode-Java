package common;

public class Solution19 {
     public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
    public ListNode removeNthFromEnd(ListNode head, int n) {
         int len=1;
        ListNode p,former;
        p=head;
        while(p.next!=null){
            len++;
            p=p.next;
        }
        if(len==n)
            return head.next;
        n=len-n+1;
        p=head;
        former=p;
        while(--n!=0){
            former=p;
            p=p.next;
        }
        former.next=p.next;
        return head;

    }
}
