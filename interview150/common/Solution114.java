package common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * FIXME:时间超越100%的人。
 * 从树的底部开始，对根节点的第一个父节点进行处理，得到一个链表，每次返回链表最后的节点的值。
 * 再逐向上，以此类推，就可以将链表延长指导与根节点右子树构成的链表连接。
 * Solution114
 */
public class Solution114 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        transform(root);
    }

    public TreeNode transform(TreeNode t) {
        if (t.left == null && t.right == null)
            return t;
        if (t.left != null && t.right != null) {
            // 一个节点是两个树叶的父节点，就将他们三个转化成链表然后返回最后的值。
            if (t.left.left == null && t.left.right == null && t.right.left == null && t.right.right == null) {
                TreeNode te = t.right;
                t.left.right = t.right;
                t.right = t.left;
                t.left = null;
                return te;

            }
        } else if (t.left == null) {
            if (t.right.left == null && t.right.right == null)
                return t.right;
        } else if (t.right == null) {
            if (t.left.left == null && t.left.right == null) {
                t.right = t.left;
                t.left = null;
                return t.right;
            }
        }

        if (t.left == null)// 如果左子树为空，就仅对右树处理，并返回右树链表的末尾
            return transform(t.right);

        if (t.right == null)// 如果右子树为空，就将左树变右树，在返回右树链表的最末尾
        {
            t.right = t.left;
            t.left = null;
            return transform(t.right);
        }

        // 在这种左右子树的都不为空的情况下，两边都要处理
        // 先将右节点保存起来
        TreeNode temp = t.right;
        // 再对左右子树进行链表化，并将各链表的末尾保存起来。
        TreeNode ll = transform(t.left);
        TreeNode rl = transform(t.right);

        t.right = t.left;
        t.left = null;
        ll.right = temp;
        return rl;

    }

}