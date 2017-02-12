package cs61b;
class ListNode {
     int val;
   ListNode next;
     ListNode(int val) {
         this.val = val;
         this.next = null;
     }
     ListNode(int val,ListNode l) {
         this.val = val;
         this.next = l;
     }
 } 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode findmiddle(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
                return slow;
    }
    public ListNode merge(ListNode head1, ListNode head2){
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
        } 
        if (head2 == null){
            tail.next = head1;
        }
        //System.out.println(dummy.next.val);
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {  
        if (head == null || head.next == null){
            return head;
        }
        ListNode mid =findmiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }
    public static void main(String[] args) {
		//ListNode head = new ListNode(21,new ListNode(25, new ListNode(25, new ListNode(31,new ListNode (4)))));
    	ListNode head = new ListNode(21);
    	head.next = new ListNode(25);
    	head.next.next = new ListNode(25);
    	head.next.next.next = new ListNode(31);
    	head.next.next.next.next = new ListNode (4);
    	Solution s = new Solution();
		head = s.sortList(head);
		for(ListNode node = head; node != null;node = node.next){
			System.out.println(node.val);
		}
	}
}
