package common;



public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
       return two(root.left,root.right);
    }
    public boolean two(TreeNode lc, TreeNode rc){
        if(lc!=null&&rc!=null){
            if(lc.val==rc.val){
                if(two(lc.right,rc.left)&&two(lc.left,rc.right))
                    return true;
                else
                    return false;
            }
            return false;
        } else if (lc==null&&rc==null) {
            return true;
        }else
            return false;
    }
}
