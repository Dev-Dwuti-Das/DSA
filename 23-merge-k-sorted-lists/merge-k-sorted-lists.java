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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        while (lists.length > 1) {
            ArrayList<ListNode> merge = new ArrayList<>();
            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1 < lists.length) ? lists[i + 1] : null;
                merge.add(merge_l1_l2(l1, l2));
            }
            lists = merge.toArray(new ListNode[0]);
        }
        return lists[0];
    }

    public ListNode merge_l1_l2(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode();
        ListNode p3 = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p3.next = p1;
                p1 = p1.next;
            } else {
                p3.next = p2;
                p2 = p2.next;
            }
            p3 = p3.next;
        }
        p3.next = (p1 == null) ? p2 : p1;
        return dummy.next;
    }
}