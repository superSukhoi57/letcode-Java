package common;


public class Solution105 {

    public TreeNode MinebuildTree(int[] preorder, int[] inorder) {
        int len=preorder.length;//两个数组一定等长的！
        return create(preorder,inorder,0,len,0,len);
    }
    public TreeNode create(int[] preorder, int[] inorder,int sp,int ep,int si,int ei){
        TreeNode root = new TreeNode(preorder[sp]);
        int root_index=si;
        while(inorder[root_index]!=preorder[sp]&&root_index<ei){
            root_index++;
        }
        int left_count=root_index-si;
        if(left_count>0)
        root.left=create(preorder,inorder,sp+1,sp+1+left_count,si,root_index);
        //注意下面我们使用了root_index+1来作为有树的开始节点，所以这里要写root_index+1!=ei，这里一开始写root_index!ei导致一直报指针越界！
        if(root_index+1!=ei)
        root.right=create(preorder,inorder,sp+1+left_count,ep,root_index+1,ei);
        return root;
    }

//————————————————————————上面是我写的，下面是答案————————————————————
    int preN = 0;
    int inoN = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return aps(preorder,  inorder, null);
    }
    public TreeNode aps(int[] pre, int[] ino, TreeNode stop){
        if(preN == pre.length || (stop != null && ino[inoN] == stop.val)){
            inoN++;
            return null;
        }
        TreeNode node = new TreeNode(pre[preN++]);
        node.left = aps(pre, ino, node);
        node.right = aps(pre, ino, stop);
        return node;
    }

    public static void main(String[] args) {
        int[]preorder={1,2,4,5,3,6,7},inorder={4,2,5,1,6,3,7};
        Solution105 test=new Solution105();
        TreeNode node=test.buildTree(preorder,inorder);
        pre(node);
    }
    //二叉树的前序遍历：
    public static void pre(TreeNode t){
        if(t!=null){
            System.out.print(t.val);
            pre(t.left);
            pre(t.right);
        }
    }

}
/*
TODO：超级牛逼的代码，根据二叉树前序遍历和中序遍历创建二叉树：
class Solution {
    int preN = 0;
    int inoN = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return aps(preorder,  inorder, null);
    }
    public TreeNode aps(int[] pre, int[] ino, TreeNode stop){
        if(preN == pre.length || (stop != null && ino[inoN] == stop.val)){
            inoN++;
            return null;
        }
        TreeNode node = new TreeNode(pre[preN++]);
        node.left = aps(pre, ino, node);
        node.right = aps(pre, ino, stop);
        return node;
    }
}
 */