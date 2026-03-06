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
    void reverse(ListNode head, ListNode tail) {
        if (head == tail)
            return;
        reverse(head.next, tail);
        head.next.next = head;
        head.next = null;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = start;
        for (int i = 1; i < k; i++) {
            end = end.next;
            if (end == null) {
                return head;
            }
        }
        head = end;
        ListNode prev = start;
        ListNode next = end.next;
        while (end != null) {
            reverse(start, end);
            start = next;
            end = start;
            if(end == null) break;
            boolean flag = true;
            for (int i = 1; i < k; i++) {
                end = end.next;
                if (end == null) {
                    flag = false;
                    break;
                }
            }
            if (!flag)
                break;
            next = end.next;
            prev.next = end;
            prev = start;
        }
        prev.next = next;
        return head;
    }
}



