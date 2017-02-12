public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
    HashMap<Integer, boolean> map = new HashMap<>();
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    while (prev.next != null){
        if (map.contains(prev.next.val)){
            prev.next = prev.next.next;
        } else {
            Map.put(prev.next.val, true);
            prev = prev.next;
        }
    }
    return dummy.next;
}