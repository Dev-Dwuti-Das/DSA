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
    public TreeNode insertIntoBST(TreeNode root, int val) {
      if(root == null) return new TreeNode(val);
      insert(root, val);  
      return root;
    }

    public void insert(TreeNode root, int val){
      TreeNode curr = root;
      while(true){
        if(val > curr.val){
          if(curr.right == null){
            TreeNode add = new TreeNode(val);
            curr.right = add;
            break;
          }else{
            curr = curr.right;
          }
        }else{
          if(curr.left == null){
            TreeNode add = new TreeNode(val);
            curr.left = add;
            break;
          }else{
            curr = curr.left;
          }
        }
      }
    }
}