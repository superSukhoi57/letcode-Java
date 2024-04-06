package common.name_duplication;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
        next=null;
    }
}
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast=head,slow=head;
        if(head==null||head.next==null)
            return false;
        while(fast!=null){
            if(fast.next!=null)
            fast=fast.next.next;
            else
                break;
            slow=slow.next;
            if(fast==slow)
                break;

        }
        if(slow==fast)
            return true;
        else
            return false;
    }
}
