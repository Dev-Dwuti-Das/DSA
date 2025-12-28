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
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    Queue<TreeNode> Q = new LinkedList<>();
    zz(root, res, 0, Q);
    return res;
  }

  public void zz(TreeNode root, List<List<Integer>> res, int count, Queue<TreeNode> Q) {
    if (root == null)
      return;
    Q.offer(root);
    while (!Q.isEmpty()) {
      List<Integer> temp = new ArrayList<>();
      int size = Q.size();
      int i = 0;
      while (i < size) {
         if (Q.peek().left != null) {
            Q.offer(Q.peek().left);
          }
          if (Q.peek().right != null) {
            Q.offer(Q.peek().right);
          }    
          if (count % 2 == 0) {
            temp.add(Q.poll().val);
          }else{
            temp.add(0, Q.poll().val);
          }        
        i++;
      }
      res.add(temp);
      count++;
    }
}}