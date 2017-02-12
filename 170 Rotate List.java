public class Solution {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int n = k % length(head);
        for (int i = 0;i < n;i++){
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
        
    }
    public int length(ListNode head){
        int length = 0;
        for(ListNode node = head; node != null; node = node.next){
            length++;
        }
        return length;
    }
}