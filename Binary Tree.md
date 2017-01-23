# Binary Tree

标签（空格分隔）： BinaryTree

---

#Binary Tree preorder traversal
根左右
## stack
```java
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new  ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null){
            return result;
        }
        stack.push(root);
        while (!stack.empty()){
            root = stack.pop();
            result.add(root.val);
            if (root.right != null){
                stack.push(root.right);
            }
            if (root.left != null){
                stack.push(root.left);
            }
        }
        return result;
    }
}
```
##tarversal
```java
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
        return result;
    }
    public void traverse(TreeNode root, ArrayList<Integer> result){
        if (root == null){
            return;
        }
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }
    
}
```
## divide and conquer
```java
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);
        
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);;
        return result;
        
    }
    
}
```
#Binary Tree Inorder Traversal
左根右
## stack
```java
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null){
        return result;
        }
        Stack<TreeNode>  stack = new Stack<TreeNode>();
        while (!stack.empty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root);
                root = root.right;
            }
        }
        return result;
    }
}
```
##tarversal
```java
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        traverse(root.left, result);
        result.add(root.val);
        traverse(root.right, result);
        return result;
    }
    public void traverse(TreeNode root, ArrayList<Integer> result){
        if (root == null){
            return;
        }
        traverse(root.left, result);
        result.add(root.val);
        traverse(root.right, result);
    }
    
}
```
## divide and conquer
```java
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        
        ArrayList<Integer> left = inorderTraversal(root.left);
        ArrayList<Integer> right = inorderTraversal(root.right);
        
        result.addAll(left);
        result.add(root.val);
        result.addAll(right);;
        return result;
        
    }
}
```
#Binary Tree Postorder Traversal
左右根
## stack
```java
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null; // previously traversed node
        TreeNode curr = root;
    
        if (root == null) {
            return result;
        }
    
        stack.push(root);
        while (!stack.empty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) { // traverse up the tree from the left
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else { // traverse up the tree from the right
                result.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
    
        return result;
    }
}
```
## divide and conquer
```java
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        
        ArrayList<Integer> left = postorderTraversal(root.left);
        ArrayList<Integer> right = postorderTraversal(root.right);
        
        result.addAll(left);
        result.addAll(right);
        result.add(root.val);
        return result;
        
    }
}
```
## traversal
```java
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        traversal(result, root);
        return result;
    }
    public void traversal(ArrayList<Integer> result, TreeNode root){
        if (root == null){
            return result;
        }
        traversal(result, root.left);
        traversal(result, root.right);
        result.add(root.val);
    }
}
```
#Binary Tree LevelOrder Traversal
## Queue
```java
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
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
        return result;
    }
}
```
##DFS
```java
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int maxlevel = 0;
        while(true){
        ArrayList<Integer> level = new ArrayList<Integer>();
        dfs(root, level, 0, maxlevel);
        if (level.size() == 0){
            break;
        }
        result.add(level);
        maxlevel++;
        }
        return result;
    }
    public ArrayList<Integer> dfs(TreeNode root, ArrayList<Integer> level, int currlevel, int maxlevel){
    if (root == null || currlevel > maxlevel){
        return level;
    }
    if (currlevel == maxlevel){
        level.add(root.val);
    }
    dfs(root.left, level, currlevel + 1, maxlevel);
    dfs(root.right, level, currlevel + 1, maxlevel);
    return level;
    }
}
```
# Binary Tree LevelOrder Traversal II
## Description
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
```java
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
```
```java
// reverse method
    public ArrayList<ArrayList<Integer>> reverse(ArrayList<ArrayList<Integer>> result){
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
}
```
#Maximum Depth of Binary Tree
## Description
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
>Example:
  1
 / \ 
2   3
   / \
  4   5
The maximum depth is 3.
## BFS
```java
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
```
## Recurrance
```java
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.max(left, right) + 1;
    }
}
```
# Minimum Depth of Binary Tree
## Description
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
## Code
```java
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0){
            return max(right,left) + 1;
        } else {
            return min(left, right) + 1;
        }
    }
}
```
# Balanced Binary Tree










