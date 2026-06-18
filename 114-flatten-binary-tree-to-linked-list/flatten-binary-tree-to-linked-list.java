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
  public void flatten(TreeNode root) {
    List<TreeNode> temp = new ArrayList<>();
    dfs(root, temp);
    // if(temp.size() < 2)
    for (int i = 0; i <= temp.size() - 2; i++) {
      temp.get(i).right = temp.get(i + 1);
      temp.get(i).left = null;
    }

  }

  public void dfs(TreeNode root, List<TreeNode> temp) {
    if (root == null)
      return;
    temp.add(root);
    dfs(root.left, temp);
    dfs(root.right, temp);
  }
}