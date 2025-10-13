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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        ListNode buffer = head;
        while( p != null && p.next != null){
            ListNode s = p.next;
            if(p.val == s.val){
                p.next = s.next;
            }else{
            p = p.next;
            }
        }
        return buffer;
    }
}