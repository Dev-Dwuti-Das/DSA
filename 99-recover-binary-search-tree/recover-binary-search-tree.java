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
    public void recoverTree(TreeNode root) {
      List<Integer> temp = new ArrayList<>();
      dfs(root, temp);
      Collections.sort(temp); //inorder;
      validate(root, temp);
    }

    public void validate(TreeNode root, List<Integer> temp){
      if(root == null) return;
      validate(root.left, temp);
      if(root.val != temp.get(idx)){
        root.val = temp.get(idx);
      }
      idx++;
      validate(root.right, temp);
    }

    public void dfs(TreeNode root, List<Integer> temp){
      if (root == null) return;
      temp.add(root.val);
      dfs(root.left, temp);
      dfs(root.right, temp);
    }
}