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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> Q = new LinkedList<>();
        if(root == null) return res;
        Q.offer(root);
        while(!Q.isEmpty()){
            int size = Q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i =  0; i < size; i++){
                if(Q.peek().left != null) Q.offer(Q.peek().left);
                if(Q.peek().right != null) Q.offer(Q.peek().right);
                temp.add(Q.poll().val);
            }
            res.add(temp);
        }
        return res;
    }
}