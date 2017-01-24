package cs61b;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class diameter {
	public static int diameter(TreeNode root){
		return helper(root).any2any;
	}
	public static result helper(TreeNode root){
		int any2any = 0;
		int root2any = 0;
		if (root == null){
			return new result(0, 0);
		}
		result left = helper(root.left);
		result right = helper(root.right);
		root2any = Math.max(left.root2any, right.root2any) + 1;
		any2any = Math.max(Math.max(left.any2any, right.any2any),left.root2any + right.root2any + 1);
		return new result(any2any, root2any);
	}
	public static void main (String[] args) {
    	//TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null),null));
    	//TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3,null,null), null));
		//TreeNode root = new TreeNode(1, new TreeNode(2,null,null),new TreeNode(3,null,null));
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.left.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
		System.out.println(diameter.diameter(root));
		}
}
class result{
    int any2any, root2any;
    public result (int any2any, int root2any){
        this.any2any = any2any;
        this.root2any = root2any;
    }
}
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
