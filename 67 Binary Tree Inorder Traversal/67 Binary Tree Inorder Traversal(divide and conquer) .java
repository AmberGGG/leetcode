public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        ArrayList<Integer> left = inorderTraversal(root.left);
        ArrayList<Integer> right = inorderTraversal(root.right);
        result.addAll(left);
        result.add(root.val);
        result.addAll(right);
        return result;
    }
}