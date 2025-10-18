public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    int cap;
    Node right;
    Node left;
    Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.right = new Node(0, 0);
        this.left = new Node(0, 0);
        this.cache = new HashMap<>();
        this.right.prev = this.left;
        this.left.next = this.right;
    }

    private void delete(Node node) {
        Node prev1 = node.prev;
        Node next1 = node.next;
        prev1.next = next1;
        next1.prev = prev1;
    }

    public void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            delete(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            delete(cache.get(key));
        }
            Node node = new Node(key,value); 
            cache.put(key, node);
            insert(node);
            
            if (cache.size() > cap) {
                Node lru = this.left.next;
                delete(lru);
                cache.remove(lru.key);
            }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */