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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        } 
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;
        while(second != null){
            ListNode forward = second.next;
            second.next = prev;
            prev = second;
            second = forward;
        }
        ListNode start = head;
        ListNode end = prev;
        while(end != null){
            ListNode temp1 = start.next;
            ListNode temp2 = end.next;
            start.next = end;
            end.next = temp1;
            start = temp1;
            end = temp2;
        }

    }
}