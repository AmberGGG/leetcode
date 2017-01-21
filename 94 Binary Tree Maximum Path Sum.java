public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        return helper(root).any2any;

    }
    public Result helper(TreeNode root){
        if (root == null){
            return new Result(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        if (root.left == null && root.right == null){
            return new Result(root.val, root.val);
        }
        Result left = helper(root.left);
        Result right = helper(root.right);
        int root2any = Math.max(0, Math.max(left.root2any, right.root2any)) + root.val;
        int any2any;
         any2any = Math.max(Math.max(left.any2any, 
                               right.any2any),
                     Math.max(0, left.root2any) + Math.max(0, right.root2any) + root.val);
        
        return  new Result(root2any, any2any);     
    }
}
class Result{
    int root2any;
    int any2any;
    public Result(int root2any, int any2any){
        this.root2any = root2any;
        this.any2any = any2any;
    }
}