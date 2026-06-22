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
  int max_sum = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    dfs(root);
    return max_sum;
  }

  public int dfs(TreeNode root) {
    if (root == null)
      return 0;

    int left = dfs(root.left);
    left = (left < 0) ? 0 : left; 
    
    int right = dfs(root.right);
    right = (right < 0) ? 0 : right;

    max_sum = Math.max(max_sum, left + right + root.val);

    return root.val + Math.max(left, right);
  }
}