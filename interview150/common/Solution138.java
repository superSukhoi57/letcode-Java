package common;

import java.util.HashMap;

public class Solution138 {

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}



        public Node copyRandomList(Node head) {

            HashMap<Node,Node> map=new HashMap<>();
            Node p=head;
            while(p!=null){
                map.put(p,new Node(p.val));
                p=p.next;
            }
            p=head;
            while(p!=null){
                map.get(p).next=map.get(p.next);
                map.get(p).random=map.get(p.random);
                p=p.next;
            }
            return map.get(head);
        }

}
