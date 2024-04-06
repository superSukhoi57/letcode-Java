package common;

//TODO：双向链表设置伪头/尾节点在删除时就可以避免空指针异常！记得要事先指明head.next和tail.prev！！

import java.util.HashMap;
import java.util.Scanner;

public class LRUCache {
    Node head,tail;
    int slideWindow,size;
    HashMap<Integer,Node>map;
    class Node{
        int key,value;
        Node prev,next;
        Node(){
            key=value=-1;
            next=prev=null;
        }
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    public LRUCache(int capacity) {
        map=new HashMap<>();
        slideWindow=capacity;
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.prev=head;//忘记加了！！😵‍💫😵‍💫😵‍💫
        size=0;
    }

    public int get(int key) {
        if(map.get(key)==null)
            return -1;
        deleteNode(map.get(key));
        putItToTail(map.get(key));
        return map.get(key).value;
    }

    public void put(int key, int value) {
        if(map.get(key)!=null){
            //已经存在这个节点。更改这个节点的值并且将他放到链表尾。
            map.get(key).value=value;
            deleteNode(map.get(key));
            putItToTail(map.get(key));
        }else if(size<slideWindow){//——————————————这里的条件分支可以优化————————————————
            Node node=new Node(key,value);
            putItToTail(node);
            size++;
            map.put(key,node);
        }else{
            Node node=new Node(key,value);
            putItToTail(node);
            map.put(key,node);
            //TODO：又是这里，同样的错误居然犯两次！！删除头节点之后，哈希表要删的key已经改变，要将他先保存起来！
            int toDe=head.next.key;
            deleteNode(head.next);
            map.remove(toDe);
        }
    }
    public void deleteNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    //将用到的节点放到链表尾部，则前面的是最久没用过的节点。
    public void putItToTail(Node node){
        tail.prev.next=node;
        node.prev=tail.prev;
        tail.prev=node;
        node.next=tail;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int count=input.nextInt();
        LRUCache test=new LRUCache(count);
        int num=100;
        int key,value;
        char ch;
        while(--num>0){
            ch=input.next().charAt(0);
            if(ch=='p'){
                key=input.nextInt();
                value= input.nextInt();
                test.put(key,value);
            }else{
                key=input.nextInt();
                int result=test.get(key);
                System.out.println("result = "+result);
            }
        }

    }
}
