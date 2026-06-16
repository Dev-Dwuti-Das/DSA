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
  int idx;
  HashMap<Integer, Integer> map = new HashMap<>();

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    idx = postorder.length-1;
    for(int i = 0; i < postorder.length; i++){
      map.put(inorder[i], i);
    }
    return helper(inorder, postorder, 0, idx);
  }

  public TreeNode helper(int[] inorder, int[] postorder, int start, int end){
    if(start > end) return null;

    TreeNode node = new TreeNode(postorder[idx--]);
    int curr = map.get(node.val);

    node.right = helper(inorder, postorder, curr + 1, end);
    node.left = helper(inorder, postorder, start, curr-1);
    return node;
  }
  
}