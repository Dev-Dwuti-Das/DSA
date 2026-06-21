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
  Map<Integer, Boolean> map;

  public boolean findTarget(TreeNode root, int k) {
    map = new HashMap<>();
    Boolean res = dfs(root, k);
    System.out.println(map);
    return res;
  }

  public boolean dfs(TreeNode root, int k) {
    if (root == null) return false;

    if (map.containsKey(root.val)) {
      return true;
    } else {
      int temp = k;
      int inverse = temp - root.val;
      map.put(inverse, true);
    }

    return dfs(root.left, k) || dfs(root.right, k);
  }
}