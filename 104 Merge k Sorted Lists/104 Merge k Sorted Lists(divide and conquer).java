public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    // divide and conquer
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0){
            return null;
        }
        return mergeHelper(lists, 0, lists.size() - 1);
    }
    public ListNode mergeHelper(List<ListNode> lists, int start, int end){
        if (start == end){
            return lists.get(start);
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, 0, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return twomerge(left, right);
    }
    public ListNode twomerge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head1 != null && head2 != null){
            if (head1.val <= head2.val){
                tail.next = head1;
                tail = tail.next;
                head1 = head1.next;
            } else {
                tail.next = head2;
                tail = tail.next;
                head2 = head2.next;
            }
        }
        if (head1 == null){
            tail.next = head2;
        } else{
            tail.next = head1;
        } 
        return dummy.next;
    }
    
}

