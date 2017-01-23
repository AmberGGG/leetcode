package cs61b;
import java.util.*;
public class gaogao {
	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        while (!q.isEmpty()){
            int qlen = q.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < qlen; i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null){
                    q.offer(root.left);
                }
                if (node.right != null){
                    q.offer(root.right);
                }
            }
            result.add(list);
        }
        
        return result;
    }
	public static void main (String[] args) {
    	//TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null),null));
    	//TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3,null,null), null));
		TreeNode root = new TreeNode(1, new TreeNode(2,null,null),new TreeNode(3,null,null));
		System.out.println(gaogao.levelOrder(root));
    }
}
class TreeNode {
	 public int val;
	 public TreeNode left, right;
	 public TreeNode(int val, TreeNode left,TreeNode right ) {
	  this.val = val;
	     this.left = left;
	     this.right = right;
	 }
		  }