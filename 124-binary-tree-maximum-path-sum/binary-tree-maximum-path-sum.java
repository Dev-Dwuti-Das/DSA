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
    int maxsum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
      if(root.left == null && root.right == null) return root.val;
      int val = mps(root);
      return maxsum;
    }
    
    public int mps(TreeNode root){
      if(root == null) return 0;
      // if(root.left != null && root.left.val < 0) return 0;
      // if(root.right != null && root.right.val < 0) return 0;
      int l = mps(root.left);
      if( l < 0){
        l = 0;
        }
      int r = mps(root.right);
      if( r < 0) {r = 0;}
      maxsum = Math.max(maxsum, root.val+l+r);
      return root.val + Math.max(l,r);
    }
}