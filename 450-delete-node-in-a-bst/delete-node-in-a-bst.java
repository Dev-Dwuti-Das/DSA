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
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null)
      return null;
    if (root.val == key) {
      return helper(root, key);
    }
    TreeNode curr = root;
    while (curr != null) {
      if (key > curr.val) {
        if (curr.right != null && curr.right.val == key) {
          curr.right = helper(curr.right, key);
        } else {
          curr = curr.right;
        }
      } else {
        if (curr.left != null && curr.left.val == key) {
          curr.left = helper(curr.left, key);
        } else {
          curr = curr.left;
        }
      }
    }

    return root;
  }

  public TreeNode helper(TreeNode root, int key) {
    TreeNode curr = root;
    if (curr.left == null) {
      return curr.right;
    }else if(curr.right == null){
      return curr.left;
    }
    else{
      TreeNode right_child = curr.right;
      TreeNode temp_left = curr.left;
      TreeNode leftmost = attach(right_child);
      leftmost.left = temp_left;
      return right_child;
    }
  }

  public TreeNode attach(TreeNode root){
    TreeNode curr = root;
    while(curr.left != null){
      curr = curr.left;
    }
    return curr;
  }

}