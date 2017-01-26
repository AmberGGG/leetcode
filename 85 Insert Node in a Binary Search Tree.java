public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (node.val < root.val){
            root.left = insertNode (root.left, node);
        }
        if (node.val > root.val){
            root.right = insertNode (root.right, node);
        }
        return root;
    }
    
}