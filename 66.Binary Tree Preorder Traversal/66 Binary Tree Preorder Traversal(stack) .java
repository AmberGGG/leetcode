public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
     //definition:寻找以root为根的树的前序遍历
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode Node = stack.pop();
            result.add(Node.val);
            if (Node.right != null){
                stack.push(Node.right);
            }
            if (Node.left != null){
                stack.push(Node.left);
            }
        }
        return result;
    }
}