package common;

import java.util.HashMap;
//TODO:题目下面的提示已经说了按升序排列，没认真审题！！
public class Solution82 {

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

    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer,Integer>map=new HashMap<>();
        ListNode p=head,former;
        while(p!=null){
            if(!map.containsKey(p.val))
                map.put(p.val, 1);
            else
                map.put(p.val,map.get(p.val)+1);
            p=p.next;
        }

        while(head!=null&&map.get(head.val)>1)
            head=head.next;
        p=head;
        former=p;
        while(p!=null){
            while(p!=null&&map.get(p.val)!=1) {
                p = p.next;
                former.next = p;
            }
            former=p;
            if(p==null)
                break;
            p=p.next;
        }

        return head;
    }
}
