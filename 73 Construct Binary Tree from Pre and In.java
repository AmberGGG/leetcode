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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0 , preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] preorder, int prestart, int preend,
                           int[] inorder, int instart, int inend){
        TreeNode root = new TreeNode(0);
        if (instart > inend){
            return null;
        } else {
            root.val = preorder[prestart];
        }
        int i = findindex(inorder, root.val);
        TreeNode left = helper(preorder, prestart + 1, prestart + i - instart,
                                  inorder, instart, i - 1);
        TreeNode right = helper(preorder, prestart + i - instart + 1, preend,
                                  inorder, i + 1, inend);
        root.left = left;
        root.right = right;
        return root;
                               
    }
    public int findindex(int[] inorder, int result){
        for(int i = 0; i < inorder.length; i++){
            if (inorder[i] == result){
                return i;
            }
        }
        return 0;
    }
}