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
    int min = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return min;
    }

     public int dfs(TreeNode root){
        if(root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        min = Math.max(min, l + r);
        return 1+Math.max(l,r);
    }
    
}