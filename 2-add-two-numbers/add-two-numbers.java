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
      ListNode p1 = l1;
      ListNode p2 = l2;
      int carry = 0;
      ListNode dummy = new ListNode(0, null);
      ListNode curr = dummy;

      while(p1 != null || p2 != null || carry != 0){
        int val1 = (p1 == null) ? 0 : p1.val;
        int val2 = (p2 == null) ? 0 : p2.val;
        int data = val1 + val2 + carry;
        int val = data%10;
        carry = data/10;
        curr.next = new ListNode(val);
        curr = curr.next;
        if(p1 != null) p1 = p1.next;
        if(p2 != null) p2 = p2.next;
      }
    return dummy.next;
    }
}