public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null){
            return result;
        }
        Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
        q.offer(root);
        while(!q.isEmpty()){
            ArrayList<Integer> list = new ArrayList<Integer>();
            int qlen = q.size();
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
            stack.push(list);
        }
        while (!stack.empty()){
            result.add(stack.pop());
        }
        return result;
      
    }
}