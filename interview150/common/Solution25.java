package common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
leetcode的搞笑代码！！

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        //首先构造一个 start 和 end，分别代表要反转的链表的前一个节点以及最后一个节点
        ListNode start = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            ListNode left = start.next;
            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null) {
                    break;
                }
            }
            if (end == null) {
                break;
            }
            ListNode next = end.next;
            //此时已经找到了要反转的链表段了
            start.next = null;
            end.next = null;
            //先把链表断开,然后从 left 开始反转,反转之后，left 是末尾节点，然后 end 是头节点
            reverseList(left);
            //再把链表连起来
            start.next = end;
            left.next = next;
            //然后将 start 和 end 重置为下一段要反转的链表的前一个节点，继续循环
            start = left;
            end = left;
        }
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
 */

public class Solution25 {
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

    //这个也许不是最高效的，但确是最低效的😒😒
    public ListNode reverseKGroup(ListNode head, int k) {
        //如果1就不用翻转
        if(k==1)
            return head;
        List<ListNode>list=new ArrayList<>();
        ListNode p=head;
        while(p!=null){
            list.add(p);
            p=p.next;
        }
        int i,j,len=list.size();
        j=0;
        for(i=k;i<=len;i+=k){//需要i<=len，要不然当k=len时进不来！
            for(j=i-1;j>i-k;j--){
                list.get(j).next=list.get(j-1);
            }
            //从第二段开始
            if(i!=k)
                list.get(i-2*k).next=list.get(i-1);
            //做完一切后判断位置，就是处理k=len的情况，这样做实际这段核心代码可以改成do-while循环！
            if(i==len)
                break;
        }
        if(i>k&&i>len)
            list.get(i-2*k).next=list.get(j+k);
        else
            list.get(i-k).next=null;
        return list.get(k-1);
    }


    @Test
    public void test(){
        int[] val={1,2,3,4,5};
        ListNode head=new ListNode(val[0],null),p;
        p=head;
        for(int i=1;i<val.length;i++){
            p.next=new ListNode(val[i],null);
            p=p.next;
        }
        p=head;
        while(p!=null)
        {
            System.out.print(p.val+" ");
            p=p.next;
        }
        System.out.println("\n");
        p=new Solution25().reverseKGroup(head,2);

        while(p!=null)
        {
            System.out.print(p.val+" ");
            p=p.next;
        }
    }
}
