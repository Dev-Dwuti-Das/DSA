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
    public boolean checkTree(TreeNode root) {
      if(root == null) return true;
      int value = check(root);
      if(value == 2*root.val) return true;
      return false;
    }

    public int check(TreeNode root){
      if(root == null) return 0;

      int left = check(root.left);
      int right = check(root.right);
      return root.val + left + right;
    }
}