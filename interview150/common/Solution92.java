package common;

public class Solution92 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int len=right-left+1,i;
        ListNode[] arr=new ListNode[len];
        ListNode start,end,former,remain,p;
        if(left==right)
            return head;
        i=right;
        p=head;
        while(--i!=0){
            p=p.next;
        }
        end=p;
        remain=p.next;
        if(left==1){
            p=head;
            for(i=0;i<len;i++){
                arr[i]=p;
                p=p.next;
            }
            for(i=len-1;i>0;i--){
                arr[i].next=arr[i-1];
            }
            arr[0].next=remain;
            return arr[len-1];
        }
        i=left-1;
        p=head;
        while(--i!=0){
            p=p.next;
        }
        former=p;
        start=p.next;
        p=start;//这里写错了，一开始写成p=gead😒😒
        for(i=0;i<len;i++){
            arr[i]=p;
            p=p.next;
        }
        former.next=arr[len-1];
        for(i=len-1;i>0;i--){
            arr[i].next=arr[i-1];
        }
        arr[0].next=remain;
        return head;

    }
}
