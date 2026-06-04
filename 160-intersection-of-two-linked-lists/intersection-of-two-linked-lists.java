/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    ListNode p1 = headA;
    ListNode p2 = headB;

    if(p1 == p2) return p1;

    while (p1 != null && p2 != null) {
      if (p1.next == null && p2.next == null && p1 != p2)
        break;

      if (p1.next == null) {
        p1 = headB;
      } else {
        p1 = p1.next;
      }

      if (p2.next == null) {
        p2 = headA;
      } else {
        p2 = p2.next;
      }

      if (p1 == p2)
        return p1;
    }
    return null;
  }
}