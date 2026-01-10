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
  Map<Integer, Integer> map = new HashMap<>();
  int idx;
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    idx = postorder.length-1;
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return helper(inorder, postorder, 0, inorder.length - 1);
  }

  public TreeNode helper(int[] inorder, int[] postorder, int ins ,int ine){
    if(ins > ine) return null;

    TreeNode tree = new TreeNode(postorder[idx]);
    idx--;
    int mid = map.get(tree.val);

    tree.right = helper(inorder, postorder, mid+1, ine);
    tree.left = helper(inorder, postorder, ins, mid-1);

    return tree;
  }
}