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
  TreeNode first;
  TreeNode mid;
  TreeNode last;
  TreeNode prev;

  public void inorder(TreeNode root) {
    if (root == null)
      return;
    inorder(root.left);
    if (prev.val > root.val) {
      if (first == null) {
        first = prev;
        mid = root;
      } else {
        last = root;
      }
    }
    prev = root;
    inorder(root.right);
  }

  public void recoverTree(TreeNode root) {
    if (root == null)
      return;
    first = mid = last = null;
    prev = new TreeNode(Integer.MIN_VALUE);
    inorder(root);
    if (first != null && last != null) {
      int temp = last.val;
      last.val = first.val;
      first.val = temp;
    } else if(first != null && mid !=null){
      int temp = mid.val;
      mid.val = first.val;
      first.val = temp;
    }
  }
}