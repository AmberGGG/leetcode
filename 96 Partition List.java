public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode leftdummy = new ListNode(0);
        ListNode rightdummy = new ListNode(0);
        ListNode left = leftdummy;
        ListNode right = rightdummy;
        ListNode node = head;
        while (node != null){
            if (node.val < x){
                left.next = node;
                left = left.next;
            } else {
                right.next = node;
                right =right.next;
            }
            node = node.next;
        }
        right.next = null;
        left.next = rightdummy.next;
        return leftdummy.next;
    }
}