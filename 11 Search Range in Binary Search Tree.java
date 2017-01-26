public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (k2 < k1){
            return result;
        }
        if (root == null){
            return result;
        }
        ArrayList<Integer> left = searchRange(root.left,k1,k2);
        ArrayList<Integer> right = searchRange(root.right,k1,k2);
        result.addAll(left);
        if (k1 <= root.val && root.val <= k2) {
            result.add(root.val);
        }
        result.addAll(right);
        return result;
    }
}