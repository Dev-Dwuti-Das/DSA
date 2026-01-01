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
      if(root == null) return root;
      return lca(root, p, q);
    }

    public TreeNode lca(TreeNode root,TreeNode p, TreeNode q){
      if(root == null || p == null || q == null) return null;

      if(root == p || root == q) return root;

      TreeNode left = lca(root.left, p, q);    //2
      TreeNode right = lca(root.right, p, q);  //8

      if(left == null && right != null){
        return right;
      }else if(left != null && right == null){
        return left;
      }
      else if(left == null && right == null){
        return null;
      }else{
        return root;
      }
    }
}