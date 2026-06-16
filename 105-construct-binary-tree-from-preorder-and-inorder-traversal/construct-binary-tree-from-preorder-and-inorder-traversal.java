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
  int idx = 0;
  Map<Integer, Integer> map = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {

    for (int i = 0; i < preorder.length; i++) {
      map.put(inorder[i], i);
    }
    return helper(preorder, inorder, 0, inorder.length - 1);
  }

  public TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
    if (start > end)
      return null;

    TreeNode node = new TreeNode(preorder[idx++]);
    int curr = map.get(node.val);

    node.left = helper(preorder, inorder, start, curr - 1);
    node.right = helper(preorder, inorder, curr + 1, end);

    return node;
  }
}