package common;

public class Solution61 {
    public class ListNode {
        int val;
       ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        int len=1;
        ListNode p=head,former,last=null;
        while(p.next!=null){
            len++;
            p=p.next;
            last=p;
        }
        if(k%len==0)
            return head;
        k%=len;
        k=len-k+1;
        p=head;
        former=p;
        while(--k!=0){
            former=p;
            p=p.next;
        }
        former.next=null;
        last.next=new ListNode();
        last.next=head;
        return p;
    }
}
