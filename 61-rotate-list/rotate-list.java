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
  public ListNode rotateRight(ListNode head, int k) {
    int n = 0;
    ListNode curr = head;
    ListNode p1 = head;
    ListNode p2 = head;

    if(head == null) return null;
    

    while (curr.next != null) {
      n++;
      curr = curr.next;
    }
    n++;

    if (n == k)
      return head;
    int real_k = k % n;
    if(real_k == 0) return head;
    int gap = n - real_k;

    if (gap == 0)
      return head;

    for (int i = 0; i < gap-1; i++) {
      p1 = p1.next;
    }
    ListNode p3 = p1.next; 

    p1.next = null;

    System.out.print(p1.val);

    curr.next = p2;

    return p3;

  }
}