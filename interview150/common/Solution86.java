package common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution86 {

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
    public ListNode partition(ListNode head, int x) {
        List<ListNode>large=new ArrayList<>(),small=new ArrayList<>();
        ListNode p=head;
        if(p==null)
            return p;
        while(p!=null){
            if(p.val<x)
                small.add(p);
            else
                large.add(p);
            p=p.next;
        }

        int ls=small.size(),ll=large.size(),i;
        for(i=0;i<ls-1;i++){
            small.get(i).next=small.get(i+1);
        }
        if(ls>0)
        small.get(ls-1).next=ll>0?large.get(0):null;

        for(i=0;i<ll-1;i++){
            large.get(i).next=large.get(i+1);
        }
        if(ll>0)
        large.get(ll-1).next=null;

        if(ls>0)
        return small.get(0);
        else
            return large.get(0);
    }
    @Test
    public void test(){
        ListNode head=new ListNode(1,null);
        new Solution86().partition(head,0);
    }
}

/*
原地改代码：leetcode运行速度最快的代码.
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(-1);
        ListNode largeHead = new ListNode(-1);
        ListNode small = smallHead;
        ListNode large = largeHead;
        while (head != null){
            if(head.val <x){
                small.next = head;
                small = small.next;
            }else{
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
 */
