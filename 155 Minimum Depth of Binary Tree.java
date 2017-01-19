public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null){
            return 0;
        }
        
        int left = root.left == null ? Integer.MAX_VALUE:minDepth(root.left);
        int right = root.right == null ? Integer.MAX_VALUE:minDepth(root.right);
        
        if (root.left == null && root.right == null){
            return 1;
        }
        
        return Math.min(left, right) + 1;
    }
}