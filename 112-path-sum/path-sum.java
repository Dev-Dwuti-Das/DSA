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
    public boolean hasPathSum(TreeNode root, int targetSum) {
      boolean val = pathsum(root, targetSum, 0);
      return val;
    }

    public boolean pathsum(TreeNode root, int targetsum, int currsum){
      if(root == null) return false;

      currsum += root.val;

      boolean l = pathsum(root.left,targetsum ,currsum);
      boolean r = pathsum(root.right,targetsum ,currsum);
     

      if(root.left == null  && root.right == null){
        return currsum == targetsum;
      }

      return l || r;
    }
}