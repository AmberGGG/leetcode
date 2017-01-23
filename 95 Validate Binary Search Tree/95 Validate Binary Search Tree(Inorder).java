package cs61b;
import java.util.*;
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public static boolean isValidBST(TreeNode root) {
        ArrayList<Integer> result = inorder(root);
        int last = 0;
        int now = 0;
        for (int i = 1; i < result.size(); i++){
            now = result.get(i);
            if (now <= last){
                return false;
            }
            last = now;
        }
        return true;
    }
    public static ArrayList<Integer> inorder(TreeNode root){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        ArrayList<Integer> left = inorder(root.left);
        ArrayList<Integer> right = inorder(root.right);
        result.addAll(left);
        result.add(root.val);
        result.addAll(right);
        System.out.println(result);
        return result;
    }

    public static void main (String[] args) {
    	//TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null),null));
    	TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3,null,null), null));
    	System.out.println(Solution.isValidBST(root));
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