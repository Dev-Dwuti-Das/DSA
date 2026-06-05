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
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    ListNode p1 = list1;
    ListNode p2 = list2;
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    while (p1 != null && p2 != null) {

      if (p1.val >= p2.val) {
        curr.next = new ListNode(p2.val);
        p2 = p2.next;
      } else {
        curr.next = new ListNode(p1.val);
        p1 = p1.next;
      }
      curr = curr.next;
    }

    if (p2 == null) {
      curr.next = p1;
    }

    if (p1 == null) {
      curr.next = p2;
    }

    return dummy.next;
  }
}