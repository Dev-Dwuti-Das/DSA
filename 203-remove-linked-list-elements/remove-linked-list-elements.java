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
    public ListNode removeElements(ListNode head, int val) {
        ListNode p = head;
        while(p != null && p.val == val){
            head = head.next;
            p = p.next;
        }
        while(p != null && p.next != null){
            ListNode s = p.next;
            if(s.val == val){
                p.next = s.next;
            }else{
                p = p.next;
            }
            
        }
    return head;
    }
}