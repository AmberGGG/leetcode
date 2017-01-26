/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        if (root == null){
            return s.toString();
        }
        serishelper(root, s);
        return s.substring(0, s.length() - 1);
        
    }
    public void serishelper(TreeNode root, StringBuilder s){
        if (root == null){
            s.append("#,");
            return;
        }
        s.append(root.val).append(",");
        serishelper(root.left, s);
        serishelper(root.right, s);
    }
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0){
            return null;
        }
        StringTokenizer s = new StringTokenizer(data, ",");
        if (!s.hasMoreTokens()){
            return null;
        }
        TreeNode root = deserihelper(s);
        return root;
    }
    public TreeNode deserihelper(StringTokenizer s){
        if (!s.hasMoreTokens()){
            return null;
        }
        String st = s.nextToken();
        if (st.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(st));
        root.left = deserihelper(s);
        root.right = deserihelper(s);
        return root;
    }
}
