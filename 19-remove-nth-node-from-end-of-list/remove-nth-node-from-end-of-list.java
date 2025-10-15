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
        ListNode dummy = new ListNode(0,head);
        ListNode first = dummy;
        ListNode second = head;
        while(n > 0){
            second = second.next;
            n--;
        }
        while(second != null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next; 
         
        return dummy.next;
    }
}