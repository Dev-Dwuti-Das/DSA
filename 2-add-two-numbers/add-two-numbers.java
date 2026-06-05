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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode dummy = new ListNode(-1, null);

    ListNode curr = dummy;

    int carry = 0;

    ListNode p1 = l1;
    ListNode p2 = l2;

    while (p1 != null && p2 != null) {

      int sum = p1.val + p2.val + carry; //18
      int curr_val = sum % 10;

      ListNode new_node = new ListNode(curr_val);

      if (sum >= 10) {
        carry = sum / 10; //1           
      } else {
        carry = 0;
      }

      p1 = p1.next;
      p2 = p2.next;
      curr.next = new_node;
      curr = curr.next;
    }

    if (p2 == null && p1 != null) {

      while (p1 != null) {

        int sum = p1.val + carry;
        int curr_val = sum % 10;

        ListNode new_node = new ListNode(curr_val);

        if (sum >= 10) {
          carry = sum / 10;
        } else {
          carry = 0;
        }
        p1 = p1.next;
        curr.next = new_node;
        curr = curr.next;
      }

      if (carry != 0) {
        curr.next = new ListNode(carry, null);
      }
    }

    if (p2 != null && p1 == null) {

      while (p2 != null) {

        int sum = p2.val + carry;
        int curr_val = sum % 10;

        ListNode new_node = new ListNode(curr_val);

        if (sum >= 10) {
          carry = sum / 10;
        } else {
          carry = 0;
        }
        p2 = p2.next;
        curr.next = new_node;
        curr = curr.next;
      }

      if (carry != 0) {
        curr.next = new ListNode(carry, null);
      }
    }
    
    if (carry != 0) {
        curr.next = new ListNode(carry, null);
      }

    return dummy.next;

  }
}