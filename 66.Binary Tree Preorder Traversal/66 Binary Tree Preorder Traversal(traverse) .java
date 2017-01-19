public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
     //definition:寻找以root为根的树的前序遍历
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    public void traverse(TreeNode root, ArrayList<Integer> result){
        //return 条件
        if (root == null){
            return;
        }
        //实现recurrance
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }
}