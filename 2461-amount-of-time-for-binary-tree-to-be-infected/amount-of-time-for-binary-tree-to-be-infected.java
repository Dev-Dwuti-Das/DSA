/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public int amountOfTime(TreeNode root, int start) {
    Map<TreeNode, TreeNode> parentmap = new HashMap<>();
    parent(parentmap, root);
    Map<TreeNode, Boolean> visited = new HashMap<>();
    Queue<TreeNode> q = new LinkedList<>();
    TreeNode st = find(root, start); 
    q.offer(st);
    visited.put(st, true);
    int k = 0;

    while (!q.isEmpty()) {
      int size = q.size();
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
    return k-1;
  }

  public TreeNode find(TreeNode root, int start){
    if(root == null) return null;
    if(root.val == start) return root;

    TreeNode left = find(root.left, start);
    TreeNode right = find(root.right, start);

    if(left == null && right != null){
      return right;
    }else if(left != null && right == null){
      return left;
    }else{
      return null;
    }
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