public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root){
        if (helper(root).isbalance){
            return true;
        }
        return false;
    }
    public ResultType helper(TreeNode root){
        boolean isbalance = false;
        if (root == null){
            return new ResultType(0, true); 
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if (left.isbalance == true && right.isbalance == true && Math.abs(left.depth - right.depth) <= 1){
            isbalance = true;
        }
        int depth = Math.max(left.depth, right.depth) + 1;
        return new ResultType(depth, isbalance);
    }
}
class ResultType{
    int depth;
    boolean isbalance;
    public ResultType(int depth, boolean isbalance){
        this.depth = depth;
        this.isbalance = isbalance;
    }
}