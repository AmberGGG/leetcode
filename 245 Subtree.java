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
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T2 == null){
            return true;
        }
        if (T1 == null){
            return false;
        }
        
        boolean left =  isSubtree(T1.left, T2);
        boolean right = isSubtree(T1.right, T2);
        
        return left || right || equalto(T1, T2);
    }
    public boolean equalto (TreeNode T1, TreeNode T2){
        if (T1 == null && T2 == null){
            return true;
        }
        if (T1 == null || T2 == null){
            return false;
        }
        if (T1.val != T2.val){
            return false;
        }
        boolean left = equalto(T1.left, T2.left);
        boolean right = equalto(T1.right, T2.right);
        return left && right;
    }
    
}