public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null){
            return result;
        }
        q.offer(root);
        int count = 1;
        while (!q.isEmpty()){
            int qlen = q.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < qlen; i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null){
                    q.offer(node.left);
                }
                if (node.right != null){
                   q.offer(node.right);
                }
            }
           if (count % 2 == 1){
                result.add(list);
            }
            if (count % 2 == 0){
                Collections.reverse(list);
                result.add(list);
            }
            count++;
        }
        return result;
    }
}
