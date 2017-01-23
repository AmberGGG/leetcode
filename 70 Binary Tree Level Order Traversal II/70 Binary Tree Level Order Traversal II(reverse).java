package cs61b;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ggg {
	public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null){
            return result;
        }
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
            result.add(list);
        }
        return reverse(result);
      
    }
    public static ArrayList<ArrayList<Integer>> reverse(ArrayList<ArrayList<Integer>> result){
        ArrayList<ArrayList<Integer>> resultrev = new ArrayList<>();
        Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
        for (ArrayList<Integer> list: result){
            stack.push(list);
        }
        while (!stack.empty()){
            resultrev.add(stack.pop());
        }
        return resultrev;
    }
	public static void main(String[] args) {
		//TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null),null));
    	//TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3,null,null), null));
		TreeNode root = new TreeNode(1, new TreeNode(2,null,null),new TreeNode(3,null,null));
		System.out.println(ggg.levelOrderBottom(root));

	}

}

//Brife Version
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
            result.add(list);
        }
        Collections.reverse(result);
        return result;
        
    }
}