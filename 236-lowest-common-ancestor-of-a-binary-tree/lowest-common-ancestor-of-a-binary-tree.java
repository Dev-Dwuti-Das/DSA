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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      return helper(root, p, q);
    }

    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
      if(root == null) return null;
      if(root == p || root == q) return root;

      TreeNode left = helper(root.left, p, q);
      TreeNode right = helper(root.right, p, q);

      if(left != null && right != null){
        return root;
      }
      
      return (left == null) ? right : left;
    }
}