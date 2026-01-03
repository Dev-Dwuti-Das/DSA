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
      if(root ==  null) return true;
      return ivb(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean ivb(TreeNode root, long min, long max){
      if(root ==  null) return true;

      if(root.val <= min) return false;
      if(root.val >= max) return false;

      return ivb(root.left, min, root.val) && ivb(root.right, root.val, max);
    }
}