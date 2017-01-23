/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root).isbst;
    }
    public result helper(TreeNode root){
        if (root == null){
            return new result(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        result left = helper(root.left);
        result right = helper(root.right);
        if (left.isbst == false || right.isbst == false){
            return new result(false, 0, 0);
        }
        if ((root.left != null && left.max >= root.val) ||
        (root.right != null && right.min <= root.val)){
            return new result(false, 0, 0);
        }
        return new result(true, Math.max(right.max, root.val), Math.min(root.val,left.min));
        
    }
}
class result{
    boolean isbst;
    int max,min;
    public result(boolean isbst, int max, int min){
        this.isbst = isbst;
        this.max = max;
        this.min = min;
    }
}