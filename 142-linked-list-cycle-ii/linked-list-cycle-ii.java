/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
      ListNode fast = head;
      ListNode slow = head;
      ListNode p1 = head;
      if(head == null || head.next == null) return null;

      while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;

        if(slow == fast) break;
      }

      if(fast == null || fast.next == null ) return null;

      while(slow.next != null && p1 != slow){
        p1 = p1.next;
        slow = slow.next;
      }
      return p1; 
    }
}