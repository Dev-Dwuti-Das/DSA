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
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    return dfs(root, subRoot);
  }

  public boolean dfs(TreeNode root, TreeNode subroot) {
    if (root == null)
      return false;
    if (subroot == null)      //yeah 
      return true;
    if (root.val == subroot.val && issubtree(root, subroot)) {
      return true;
    }
    return dfs(root.left, subroot) || dfs(root.right, subroot);
  }

  public boolean issubtree(TreeNode root, TreeNode subroot) {
    if (root == null && subroot == null)
      return true;

    if ((root == null && subroot != null) || (root != null && subroot == null))
      return false;

    if (root.val != subroot.val)
      return false;

    boolean l = issubtree(root.left, subroot.left);
    boolean r = issubtree(root.right, subroot.right);

    return l && r;
  }
}