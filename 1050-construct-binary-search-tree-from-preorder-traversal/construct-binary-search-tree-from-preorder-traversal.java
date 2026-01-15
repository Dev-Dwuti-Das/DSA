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
  int idx= 0;
    public TreeNode bstFromPreorder(int[] preorder) {
      TreeNode root = new TreeNode(preorder[idx++]);
      helper(preorder, Integer.MAX_VALUE, root);
      return root;
    }


    public void helper(int[] preorder, int UB,  TreeNode root){
      if( root == null || idx >= preorder.length ) return;

      if(idx < preorder.length && preorder[idx] < root.val ){
        root.left = new TreeNode(preorder[idx++]);
        helper(preorder, root.val, root.left);
      }
      else{
        root.left = null;
      }

      if(idx < preorder.length && preorder[idx] > root.val && preorder[idx] < UB){
        root.right = new TreeNode(preorder[idx++]);
        helper(preorder, UB, root.right);
      }
      else{
        root.right = null;
      }      
    }
}