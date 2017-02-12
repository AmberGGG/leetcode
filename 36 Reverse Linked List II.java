/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < m; i++){
            pre = pre.next;
        }
        ListNode curr = pre.next;
        ListNode prev = null;
        while (curr != null && m <= n){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            m++;
        }
        pre.next.next = curr;
        pre.next = prev;
        return dummy.next;
    }
}