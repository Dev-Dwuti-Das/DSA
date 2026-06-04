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
  public ListNode deleteMiddle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    ListNode p1 = new ListNode(-1, head);

    if(head.next == null) return null;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      p1 = p1.next;
    }

    // while (p1.next != null && p1.next != slow){
    //   p1 = p1.next;
    // }

    p1.next = slow.next;

    return head;
  }
}