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
  Map<Integer, Integer> map;

  public TreeNode bstFromPreorder(int[] preorder) {
    map = new HashMap<>();
    int[] inorder = new int[preorder.length];
    for (int i = 0; i < inorder.length; i++) {
      inorder[i] = preorder[i];
    }
    Arrays.sort(inorder);

    for (int i = 0; i < preorder.length; i++) {
      map.put(inorder[i], i);
    }

    return helper(0, preorder.length - 1, inorder, preorder);
  }

  public TreeNode helper(int st, int end, int[] inorder, int[] preorder) {
    if (st > end)
      return null;

    TreeNode node = new TreeNode(preorder[idx++]);
    int mid = map.get(node.val);

    node.left = helper(st, mid - 1, inorder, preorder);
    node.right = helper(mid + 1, end, inorder, preorder);

    return node;
  }
}