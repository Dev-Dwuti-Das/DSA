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
  int min = 0;
  int count = 0;
    public int kthSmallest(TreeNode root, int k) {
      preorder(root, k);
      return min;
    }

    public void preorder(TreeNode root, int k){
      if(root == null) return;
      preorder(root.left, k);
      count++;
      if(count == k){
        min = root.val;
      }
      preorder(root.right, k);      
    }
}