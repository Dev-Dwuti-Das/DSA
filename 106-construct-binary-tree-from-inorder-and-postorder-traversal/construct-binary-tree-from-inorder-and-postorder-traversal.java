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
  HashMap<Integer, Integer> map = new HashMap<>();
  int idx;
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    idx = postorder.length - 1;
    for(int i = 0; i < postorder.length; i++){
      map.put(inorder[i], i);
    }
    return helper(inorder, postorder, 0, postorder.length-1);
  }

  public TreeNode helper(int[] inorder, int[] postorder, int st, int end){
    if(st > end) return null;

    TreeNode node = new TreeNode(postorder[idx]);
    idx--;
    int curr = map.get(node.val);

    node.right = helper(inorder, postorder, curr+1, end);
    node.left = helper(inorder, postorder, st, curr-1);

    return node;
  }
}