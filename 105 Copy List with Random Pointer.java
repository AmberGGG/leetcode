public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode prev = dummy;
        while(node != null){
            RandomListNode curr = new RandomListNode(node.label);
            map.put(node, curr);
            prev.next = curr;
            prev = curr;
            node = node.next;
        }
        node = head;
        while (node != null){
            map.get(node).random = node.random;
            node = node.next;
        }
        return dummy.next;
    }
}
+
