public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {  
        if (head == null){
            return null;
        }
        return helper(head);
    }
    public TreeNode helper(ListNode head){
        if (head == null){
            return null;
        }
        if (head.next == null){
            return new TreeNode(head.val);
        }
        ListNode bmid = findbmid(head);
        TreeNode root = new TreeNode(bmid.next.val);
        ListNode head2 = bmid.next.next;
        bmid.next = null;
        TreeNode left = helper(head);
        TreeNode right = helper(head2);
        root.left = left;
        root.right = right;
        return root;
    }
    public ListNode findbmid(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

