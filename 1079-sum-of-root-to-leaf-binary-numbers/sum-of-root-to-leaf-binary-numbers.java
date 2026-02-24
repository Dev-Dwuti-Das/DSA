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
    public int sumRootToLeaf(TreeNode root) {
        int sum = 0;
        if (root.left == null & root.right == null) return root.val;
        List<String> list = new ArrayList<>();
        dfs(root, list, "");
        for (int i = 0; i < list.size(); i++) {
            sum += Integer.parseInt(list.get(i), 2);
        }
        return sum;
    }

    public void dfs(TreeNode root, List<String> list, String temp) {
        if(root == null) return;
        if (root.left == null && root.right == null) {
            int val = root.val;
            list.add(temp + val);
            System.out.println(temp + val);
            return;
        }
        int val = root.val;
        dfs(root.left, list, temp + val);
        dfs(root.right, list, temp + val);
    }

}