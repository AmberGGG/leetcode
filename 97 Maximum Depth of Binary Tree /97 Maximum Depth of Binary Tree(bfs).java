public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int count = 0;
        q.offer(root);
        while (!q.isEmpty()){
            int qlen = q.size();
            for (int i = 0; i < qlen; i++){
                TreeNode node = q.poll();
                if (node.left != null){
                    q.offer(node.left);
                }
                if (node.right != null){
                    q.offer(node.right);
                }
            }
            count ++;
        }
        return count;
    }
}