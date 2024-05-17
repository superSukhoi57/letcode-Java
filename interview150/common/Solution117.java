package common;

import java.util.LinkedList;
import java.util.Queue;

public class Solution117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null)
            return root;

        // TODO：我这么做的难点在于下一次循环开始是的起始位置的确定。
        Node start, end, p, former, nextstart, nextend = null;
        start = end = root;
        while (start != null) {
            former = null;
            // 一开始就要确定起点。避免第一次循环在深度为1,也就是根节点时因起点失效导致循环退出
            if (start.left != null)
                nextstart = start.left;
            else
                nextstart = start.right;

            for (p = start; p != end; p = p.next) {
                // 在起点空时要选出下一层第一个适合起点的节点
                if (nextstart == null) {
                    if (p.left != null)
                        nextstart = p.left;
                    else
                        nextstart = p.right;
                }

                // 连接下一层父节点不同的节点
                if (former != null) {
                    if (former.right != null) {
                        if (p.left != null)
                            former.right.next = p.left;
                        else
                            former.right.next = p.right;
                    } else if (former.left != null) {
                        if (p.left != null)
                            former.left.next = p.left;
                        else
                            former.left.next = p.right;
                    }
                }
                // 连接下一层可能存在的两个孩子
                if (p.left != null)
                    p.left.next = p.right;
                // 当下一层的节点不是最后一个时，不断更新直到最后一个，存入nextend，用来更新下一次循环的end
                if (p.right != null)
                    nextend = p.right;
                else if (p.left != null)
                    nextend = p.left;
                // 对于连接下一层的孩子的父节点来说，如果这个节点没有后代就绕过他。
                if (!(p.left == null && p.right == null))
                    former = p;
            }

            // ————————————————————————对最后一次进行和前面节点相同的操作start——————————————————
            if (former != null) {
                if (former.right != null) {
                    if (p.left != null)
                        former.right.next = p.left;
                    else
                        former.right.next = p.right;
                } else if (former.left != null) {
                    if (p.left != null)
                        former.left.next = p.left;
                    else
                        former.left.next = p.right;
                }
            }
            if (end.left != null)
                end.left.next = end.right;
            // ————————————————————————对最后一次进行和前面节点相同的操作end——————————————————
            // 就时这里要特别注意，如果下一次循环的起点在最后一次的遍历时，需要和前面一样的代码！debug发现的
            if (nextstart == null) {
                if (p.left != null)
                    nextstart = p.left;
                else
                    nextstart = p.right;
            }
            // 和循环里面一样的，对结束点进行迭代
            if (end.right != null)
                nextend = end.right;
            else if (end.left != null)
                nextend = end.left;
            // 更新下一次循环的起始点
            start = nextstart;
            end = nextend;
        }
        return root;
    }

    public Node create_level(int[] a) {
        int len = a.length, i = 0;
        Queue<Node> que = new LinkedList<>();
        Node root = new Node(a[i++]), p, t;
        que.add(root);
        while (!que.isEmpty()) {
            p = que.poll();
            if (a[i] != 0) {
                t = new Node(a[i++]);
                // TODO：之前判断退出的if写在这里，此时创建的新子节点还没赋值给当前节点
                p.left = t;
                que.add(t);
                if (i == len)
                    break;
            } else {
                i++;
            }
            if (a[i] != 0) {
                t = new Node(a[i++]);

                p.right = t;
                que.add(t);
                if (i == len)
                    break;
            } else {
                i++;
            }
        }

        return root;

    }

    public void show_level(Node root) {
        Queue<Node> que = new LinkedList();
        que.add(root);
        Node p;
        while (!que.isEmpty()) {
            p = que.poll();
            System.out.print(p.val);
            if (p.left != null)
                que.add(p.left);
            if (p.right != null)
                que.add(p.right);
        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        int[] a = { 1, 7, 9, 0, 0, -1, -7, 0, 8, -9 };
        Solution117 test = new Solution117();
        Node root = test.create_level(a);
        test.show_level(root);
        test.connect(root);
        test.show_level(root);
    }
}
