/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public List<Integer> distanceK(TreeNode root, TreeNode target, int p) {
    Map<TreeNode, TreeNode> parentmap = new HashMap<>();
    ArrayList<Integer> res = new ArrayList<>();
    parent(parentmap, root);
    Map<TreeNode, Boolean> visited = new HashMap<>();
    Queue<TreeNode> q = new LinkedList<>();
    int k = 0;
    q.offer(target);
    visited.put(target, true);

    while (!q.isEmpty()) {
      int size = q.size();
      if (k == p)
        break;
      for (int i = 0; i < size; i++) {
        TreeNode item = q.poll();
        if (visited.get(item.left) == null && item.left != null) {
          visited.put(item.left, true);
          q.offer(item.left);
        }
        if (visited.get(item.right) == null && item.right != null) {
          visited.put(item.right, true);
          q.offer(item.right);
        }
        if (visited.get(parentmap.get(item)) == null && parentmap.get(item) != null) {
          visited.put(parentmap.get(item), true);
          q.offer(parentmap.get(item));
        }

      }
      k++;
    }

    while (!q.isEmpty()) {
      res.add(q.poll().val);
    }

    return res;

  }

  public void parent(Map<TreeNode, TreeNode> map, TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    map.put(root, null);
    q.offer(root);

    while (!q.isEmpty()) {
      TreeNode item = q.poll();

      if (item.left != null) {
        q.offer(item.left);
        map.put(item.left, item);
      }
      if (item.right != null) {
        q.offer(item.right);
        map.put(item.right, item);
      }
    }
  }

}