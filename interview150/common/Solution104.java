package common;

public class Solution104 {
        public int maxDepth(TreeNode root) {
            if(root==null)
                return 1;
            int x=maxDepth(root.left),y=maxDepth(root.right);
            return 1+(x>y?x:y);//TODO:(x>y?x:y)要写（）
        }
}
