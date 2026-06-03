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
    ListNode dummy = new ListNode(-1, head);
    ListNode curr = dummy;
    ListNode right = dummy;

    if (head == null || head.next == null)
      return null;

    for (int i = 0; i <= n; i++) {
      right = right.next;
    }

    while (right != null) {
      curr = curr.next;
      right = right.next;
    }

    curr.next = curr.next.next;
    return dummy.next;
  }
}