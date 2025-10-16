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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
           return head;
        }
        ListNode dummy = new ListNode(0 , head);
        int left_temp = left;
        ListNode prev = dummy;
        ListNode curr = head;
        while(left-1 > 0){
            curr = curr.next;
            prev = prev.next;
            left--;
        }
        ListNode lprev = prev;
        prev = null;
        int distance = right - left_temp + 1;
        while(distance > 0){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            distance--;
        }
        // System.out.print(curr.val);
        lprev.next.next = curr;
        lprev.next = prev;
        return dummy.next; 
    }
}