package common;


public class Solution21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;
        else if(list2==null)
            return list1;
        ListNode head=list1.val<list2.val?list1:list2,now;
        if(head==list1)
            list1=list1.next;
        else
            list2=list2.next;
        now=head;
        while(list1!=null&&list2!=null)
        {
            if(list1.val<list2.val){
                now.next=list1;
                now=list1;
                list1=list1.next;
            }else{
                now.next=list2;
                now=list2;
                list2=list2.next;
            }
        }
        if(list1==null)
            now.next=list2;
        else
            now.next=list1;
        return head;

    }

}
