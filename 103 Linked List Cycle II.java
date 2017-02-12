/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        if (head == null || head.next == null){
            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow){
            if (fast == null ||fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        while (head != slow.next){
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
