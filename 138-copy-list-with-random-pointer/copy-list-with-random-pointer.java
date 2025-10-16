/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
    Map <Node,Node> old2new = new HashMap<>();
    Node curr = head;
    while(curr != null){
        Node copy = new Node(curr.val);
        old2new.put(curr,copy);
        curr = curr.next;
    }
    curr = head;
    while(curr != null){
        Node copy = old2new.get(curr);
        copy.next = old2new.get(curr.next);
        copy.random = old2new.get(curr.random);
        curr = curr.next;
    }
    return old2new.get(head);
    }
}