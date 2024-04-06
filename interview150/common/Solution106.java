package common;

public class Solution106 {
    int len;
    int li;
    int lp;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        len=inorder.length;
        lp=len-1;
        li=lp;
        return create(inorder,postorder,null);
    }
    public TreeNode create(int[] ino, int[] post,TreeNode stop){
        if(lp<0 || (stop != null && ino[li] == stop.val)){
            li--;
            return null;
        }
        TreeNode node = new TreeNode(post[lp--]);
        node.right = create(post, ino, node);
        node.left = create(post, ino, stop);
        return node;
    }

    public static void main(String[] args) {
        Solution106 test=new Solution106();
        int[] postorder={4,5,2,6,7,3,1},inorder={4,2,5,1,6,3,7};
        TreeNode node=test.buildTree(inorder,postorder);
        pre(node);
    }
    public static void pre(TreeNode t){
        if(t!=null){
            System.out.print(t.val);
            pre(t.left);
            pre(t.right);
        }
    }
}
