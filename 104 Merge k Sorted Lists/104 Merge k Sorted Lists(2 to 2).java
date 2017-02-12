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
        List<ListNode> beforelist = lists;
        //List<ListNode> result = new ArrayList<ListNode>();
        //List<ListNode> afterlist = new ArrayList<ListNode>();
        while (beforelist.size() > 1){
            List<ListNode> afterlist = new ArrayList<ListNode>();
            for (int j = 0; j < beforelist.size(); j = j + 2){
                if (j + 1 == beforelist.size()){
                    afterlist.add(beforelist.get(j));
                    break;
                }
                ListNode head1 = beforelist.get(j);
                ListNode head2 = beforelist.get(j + 1);
                afterlist.add(twomerge(head1, head2));
            }
            beforelist = afterlist;
        }
        return beforelist.get(0);
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
