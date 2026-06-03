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

      if(p1 == slow) return p1;

      while(p1 != null){
        p1 = p1.next;
        slow = slow.next;

        if(p1 == slow) break;
      }
      return p1; 
    }
}