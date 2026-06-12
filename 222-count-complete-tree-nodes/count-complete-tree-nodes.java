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
  public int countNodes(TreeNode root) {
    return helper(root);
  }

  public int helper(TreeNode root) {
    if (root == null)
      return 0;

    int left_height = heightleft(root);
    int right_height = heightright(root);

    if (left_height != 0 && left_height == right_height)
      return (int) Math.pow(2, left_height) - 1;

    int nodeleft = helper(root.left);
    int noderight = helper(root.right);

    return 1 + nodeleft + noderight;
  }

  public int heightleft(TreeNode root) {
    if (root == null)
      return 0;
    return 1 + heightleft(root.left);
  }

  public int heightright(TreeNode root) {
    if (root == null)
      return 0;
    return 1 + heightright(root.right);
  }

}