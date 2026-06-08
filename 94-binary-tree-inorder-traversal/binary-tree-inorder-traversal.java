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
  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null)
      return new ArrayList<>();
    Stack<TreeNode> st = new Stack<>();
    List<Integer> res = new ArrayList<>();
    TreeNode curr = root;

    while (!st.isEmpty() || curr != null) {

      while (curr != null) {
        st.add(curr);
        curr = curr.left;
      }

      TreeNode node = st.pop(); 
      res.add(node.val);

      curr = node.right;
    }
    return res;
  }

}
