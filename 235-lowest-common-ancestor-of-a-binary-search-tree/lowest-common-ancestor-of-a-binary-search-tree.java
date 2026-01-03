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
      if(root == null || p == null || q == null) return root;
      TreeNode res = LCA(root, p , q);
      return res;
    }
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
      if(root == null || p == null || q == null) return null;

      if(root == p || root == q) return root;

      TreeNode left = LCA(root.left, p , q);
      TreeNode right = LCA(root.right, p , q);

      if(left == null && right == null){
        return null;
      }else if(left != null && right == null){
        return left;
      }else if(left == null && right != null){
        return right;
      }else{
        return root;
      }
    }
}