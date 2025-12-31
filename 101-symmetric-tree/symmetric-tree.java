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
    public boolean isSymmetric(TreeNode root) {
      if(root == null) return true;
      return iss(root.left, root.right); 

    }

    public boolean iss(TreeNode left, TreeNode right){
      if(left == null || right == null) return left == right;

      if(left.val != right.val) return false;

      return iss(left.left, right.right) && iss(left.right, right.left); 
    }
}