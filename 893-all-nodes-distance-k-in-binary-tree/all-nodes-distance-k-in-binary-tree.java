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
  public void baap(TreeNode root, Map<TreeNode, TreeNode> parent) {
    Queue<TreeNode> Q = new LinkedList<>();
    Q.offer(root);
    while (!Q.isEmpty()) {
      TreeNode item = Q.poll();
      if (item.left != null) {
        Q.add(item.left);
        parent.put(item.left, item);
      }

      if (item.right != null) {
        Q.add(item.right);
        parent.put(item.right, item);
      }

    }
  }

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    baap(root, parent);
    Map<TreeNode, Boolean> visited = new HashMap<>();
    Queue<TreeNode> Q = new LinkedList<>();
    Q.offer(target);
    visited.put(target, true);
    int lvl = 0;
    while (!Q.isEmpty()) {
      int size = Q.size();
      if (lvl == k)
        break;
      lvl++;
      for (int i = 0; i < size; i++) {
        TreeNode item = Q.poll();
        if (item.left != null && visited.get(item.left) == null) {
          Q.add(item.left);
          visited.put(item.left, true);
        }
        if (item.right != null && visited.get(item.right) == null) {
          Q.add(item.right);
          visited.put(item.right, true);
        }
        if (parent.get(item) != null && visited.get(parent.get(item)) == null) {
          Q.add(parent.get(item));
          visited.put(parent.get(item), true);
        }
      }
    }

    List<Integer> res = new ArrayList<>();
    while (!Q.isEmpty()) {
      res.add(Q.poll().val);
    }
    return res;
  }
}