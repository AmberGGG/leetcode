public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    //traverse
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
     public void traverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null){
            return;
        }
        traverse(root.left, result); 
        traverse(root.right, result); 
        result.add(root.val);
     }
}