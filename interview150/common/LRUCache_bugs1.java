package common;

public class LRUCache_bugs1 {
    private Node head,last;
    int slideWindow,size;
    class Node{
        int key,value;
        Node next,before;
        Node(){
            key=value=-1;
            next=null;
        }
        Node(int key,int value){
            this.key=key;
            this.value=value;
            next=null;
            before=null;
        }
    }

    public LRUCache_bugs1(int capacity) {
        slideWindow=capacity;
        head=null;
        size=0;
    }

    public int get(int key) {
        Node p=last;
        while(p!=null){
            if(p.key==key){
                last.next=new Node(p.key,p.value);
                last.next.before=last;
                last=last.next;
                if(p==head) {
                    head = head.next;
                    head.before=null;
                }
                else
                    p.before.next=p.next;
                return p.value;
            }
            p=p.before;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node p=last;
        while(p!=null){
            if(p.key==key){
                last.next=new Node(key,value);
                last.next.before=last;
                last=last.next;
                if(p==head) {
                    head = head.next;
                    head.before=null;
                }
                else
                    p.before.next=p.next;

                return;
            }
            p=p.before;
        }
        if(head==null){
            head=new Node(key,value);
            size++;
            last=head;
        }
        else if(size<slideWindow){
            last.next=new Node(key,value);
            last.next.before=last;
            size++;
            last=last.next;
        }else{
            //将最久没用过的缓存挤掉！
            last.next=new Node(key,value);
            last.next.before=last;
            last=last.next;
            head=head.next;
            head.before=null;
        }

    }
}
