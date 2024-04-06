package common;

public class LRUCache_old {
    private Node head,last;
    int slideWindow,size;
    class Node{
        int key,value;
        Node next;
        Node(){
            key=value=-1;
            next=null;
        }
        Node(int key,int value){
            this.key=key;
            this.value=value;
            next=null;
        }
    }

    public LRUCache_old(int capacity) {
        slideWindow=capacity;
        head=null;
        size=0;
    }

    public int get(int key) {
        Node p=head,former;
        former=p;
        while(p!=null){
            if(p.key==key) {
                int answer=p.value;//先将p的value报存起来，以免key是head时用p.value返回它的下一个！
                last.next=new Node(p.key,p.value);
                last=last.next;
                former.next=p.next;
                if(former==head)
                    head=head.next;
                return answer;
            }
            former=p;
            p=p.next;
        }

        return -1;
    }

    public void put(int key, int value) {
        if(head==null){
            head=new Node(key,value);
            size++;
            last=head;
        }
        else if(size<slideWindow){
            last.next=new Node(key,value);
            size++;
            last=last.next;
        }else{
            //将最久没用过的缓存挤掉！
            last.next=new Node(key,value);
            last=last.next;
            head=head.next;
        }

    }
}
