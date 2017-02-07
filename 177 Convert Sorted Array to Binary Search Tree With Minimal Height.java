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
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) { 
        if (A == null || A.length == 0){
            return null;
        }
        return helper(A, 0, A.length - 1);
    }  
    public TreeNode helper(int[] A, int start, int end){
        
        if (start > end){
            return null;
        }
        TreeNode root = new TreeNode(A[(start + end) / 2]);
        root.left = helper(A, start, (start + end) / 2 - 1);
        root.right = helper(A, (start + end) / 2 + 1,end);
        return root;
    }
}
