public class Solution {
    /**
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || preorder == null){
            return null;
        }
        if (inorder.length == 0 || preorder.length == 0){
            return null;
        }
        if (inorder.length != preorder.length){
            return null;
        }
        return helper(inorder, 0 ,inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode helper(int[] inorder, int instart, int inend, 
                           int[] postorder, int poststart, int postend){
        if (instart > inend){
            return null;
        }      
        TreeNode root = new TreeNode(postorder[postend]);
        int i = findindex(inorder, root.val);
        TreeNode left = helper(inorder, instart, i - 1, postorder, poststart, 
                               poststart + i - instart - 1);
        TreeNode right = helper(inorder, i + 1, inend, postorder, 
                                 poststart + i - instart, postend - 1);     
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
        return -1;
    }
}