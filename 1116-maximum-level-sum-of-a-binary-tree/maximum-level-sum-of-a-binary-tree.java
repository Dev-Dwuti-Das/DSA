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
  public int maxLevelSum(TreeNode root) {
    Map<Integer, Integer> map = new HashMap<>();
    int max = root.val;
    int lvl = 1;
    map.put(lvl, max);
    Queue<TreeNode> Q = new LinkedList<>();
    if (root == null)
      return max;
    Q.offer(root);
    while (!Q.isEmpty()) {
      int size = Q.size();
      int currsum = 0;
      for (int i = 0; i < size; i++) {
        TreeNode item = Q.poll();
        currsum += item.val;
        if (item.left != null) {
          Q.offer(item.left); 
        }
        if (item.right != null) {
          Q.offer(item.right);
        }

        
      }
      map.put(lvl, currsum);
      lvl++;
    }
    int ansKey = Integer.MAX_VALUE;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int key = entry.getKey();
      int val = entry.getValue();

      if (val > max || (val == max && key < ansKey)) {
        max = val;
        ansKey = key;
      }
    }
    System.out.print(map);
    return ansKey;
  }
}