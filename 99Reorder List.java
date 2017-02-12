public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        ListNode mid = findmid(head);
        ListNode head2 = reverse(mid.next);
        mid.next = null;
        head = merge(head, head2);
    }
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (head1 != null && head2 != null){
            tail.next = head1;
            head1 = head1.next;
            tail = tail.next;
            tail.next = head2;
            tail = tail.next;
            head2 =  head2.next;
        }
        tail.next = head1;
        return dummy.next;
    }
    public ListNode findmid(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
    return prev;
    }
}

