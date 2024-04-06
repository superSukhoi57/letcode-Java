package common;

public class Solution226 {

    public TreeNode invertTree(TreeNode root) {
        if(root!=null){
            TreeNode temp=root.right;
            root.right=root.left;
            root.left=temp;
            invertTree(root.right);
            invertTree(root.left);
        }
        return root;
    }
}
