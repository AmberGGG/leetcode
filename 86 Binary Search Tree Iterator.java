package cs61b;
import java.util.*;
public class Solution {
	
	public static void main (String[] args) {
    	//TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null),null));
    	//TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3,null,null), null));
		TreeNode root = new TreeNode(-1, null,null);
		BSTIterator iterator = new BSTIterator(root);
		while (iterator.hasNext()) {
		 TreeNode node = iterator.next();
    	 System.out.println(node.val);
		}
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
class BSTIterator {
    //@param root: The root of binary tree.
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode curr;
    public BSTIterator(TreeNode root) {
        // write your code here
        curr = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return(curr != null || !stack.empty());
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
        while (curr != null){
            stack.push(curr);
            curr = curr.left;
        }
            curr = stack.pop();
            TreeNode node = curr;
            curr = curr.right;
        return node;
    }
}