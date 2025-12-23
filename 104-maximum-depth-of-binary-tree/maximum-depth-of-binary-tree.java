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
    public int maxDepth(TreeNode root) {
        return dfs(root, 1);
    }

    public int dfs(TreeNode root, int height){
        if(root == null) return 0;

        int l = 1 + dfs(root.left, height);
        int r = 1 + dfs(root.right, height);
        return Math.max(l, r);
    }
}