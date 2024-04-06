package algorithm;

import java.util.ArrayList;
import java.util.List;

public class 用堆栈实现链表155 {
    int top;
    List<Integer>arr;
    public 用堆栈实现链表155() {
        arr=new ArrayList<>();
        top=0;
    }

    public void push(int val) {
        arr.add(val);
        top++;
    }

    public void pop() {
        top--;
        if(top>=0)
            arr.remove(top);

    }

    public int top() {
        return arr.get(top-1);
    }

    public int getMin() {
            int min=arr.get(0),t;
            for(int i=1;i<top;i++){
                t=arr.get(i);
                if(min>t)
                    min=t;
            }
            return min;
    }
}

/*
//leetcode的高速代码：使用链表和内部类实现，关键在于理解push操作！！

class MinStack {

    private Node head;
    private   class Node{
        int val;
        Node next;
        int min;
        Node( int value,int min){
            this.val=value;
            this.next=null;
            this.min=min;
        }
        Node( int value,int min,Node next){
            this.val=value;
            this.next=next;
            this.min=min;
        }
    }
    public MinStack() {
    }

    public void push(int val) {
        if(head==null){
        head=new Node(val,val);//刚开始为空就创建节点！
        }
        else{
        //这一步的理解：先将创建栈顶节点并将现在的栈顶指针head作为它的next指针，然后将创建的新节点赋值给现在的head
        //也就是说next是往前指的，现在创建的节点的next指针指向原来的栈顶，然后将head指向现在的节点作为栈顶，这样head就逻辑上指向栈顶！
        head= new Node(val,Math.min(val,head.min),head);
        }
    }

    public void pop() {
        head=head.next;
    }

    public int top() {
        return head.val;

    }

    public int getMin() {
        return head.min;

    }
}

 */


/*                 （head）—·——·——·——·>head
————————        ————————            ——————————
|  1    |       |  2    |           |    3   |
| ——————|       |———————|           |————————|
| NULL  |<——————|- next |<——————————|next    |
————————        ————————            ——————————


 */