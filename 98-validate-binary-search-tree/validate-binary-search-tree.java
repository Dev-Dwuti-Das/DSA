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
    public boolean isValidBST(TreeNode root) {
      if(root.left == null && root.right == null) return true;
      long max = (long)1e10;
      long min = -(long)1e10;
      return helper(root, max, min);
    }

    public boolean helper(TreeNode root, long max, long min){
      if(root == null) return true;
      if(max <= root.val || root.val <= min) return false;
      return helper(root.left, root.val, min) && helper(root.right, max, root.val); 
    }
}