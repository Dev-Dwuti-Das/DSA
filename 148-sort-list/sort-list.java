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
  public ListNode sortList(ListNode head) {
    return helper(head);
  }

  public ListNode helper(ListNode head) {

    if (head == null || head.next == null)
      return head;

    ListNode mid = middle(head);
    ListNode righthead = mid.next;
    mid.next = null;

    ListNode part1 = helper(head);
    ListNode part2 = helper(righthead);

    return merge(part1, part2);
  }

  public ListNode merge(ListNode list1, ListNode list2) {

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

  public ListNode middle(ListNode head) {
    ListNode fast = head.next;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
}