/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sizeOfLinkedList = 0;
        ListNode dummy = head;

        while(dummy != null) {
            sizeOfLinkedList++;
            dummy = dummy.next;
        }

        int indexToRemove = sizeOfLinkedList - n;

        int ind = 0;
        ListNode result = new ListNode(0);
        ListNode tailNode = result;

        //use extra O(N) space
        while(head != null) {
            if(ind == indexToRemove) {
                tailNode.next = head.next;
                head = tailNode.next;
            } else {
                tailNode.next = new ListNode(head.val);
                head = head.next;
                tailNode = tailNode.next;
            }
            ind++;
        }

        return result.next;
    }
}