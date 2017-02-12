public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    private Comparator<ListNode> lncomp = new Comparator<ListNode>(){
        public int compare(ListNode left, ListNode right){
            if (left == null){
                return 1;
            } 
            if (right == null){
                return -1;
            }
            return left.val - right.val;
        }
    };
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0){
            return null;
        }
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), lncomp);
        for (int i = 0; i < lists.size(); i++){
            if (lists.get(i) != null){
                heap.add(lists.get(i));
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!heap.isEmpty()){
            ListNode head = heap.poll();
            tail.next = head;
            tail = tail.next;
            if (head.next != null){
                heap.add(head.next);
            }
        }
        tail.next = null;
        return dummy.next;
    }
    
}
