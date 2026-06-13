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

class pair{
  TreeNode node;
  int col;

  pair(TreeNode node, int col){
    this.node = node;
    this.col = col;
  }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
      int maxi = Integer.MIN_VALUE; 
      Queue<pair> q = new LinkedList<>();
      q.offer(new pair(root, 0));

      while(!q.isEmpty()){
        pair item = q.peek();
        TreeNode node = item.node;
        int min = item.col;
        int size = q.size();
        int start = 0;
        int end = 0;
        for(int i = 0; i < size; i++){
          pair child = q.poll();
          if(i == 0) start = child.col;
          if(i == size-1) end = child.col;
          TreeNode node1 = child.node;
          int col = child.col; 
          if(node1.left != null) q.offer(new pair(node1.left, (2*col + 1) - min));
          if(node1.right != null) q.offer(new pair(node1.right, (2*col + 2) - min));
        }
        maxi = Math.max(maxi, end - start + 1);
      } 
      return maxi;
    }
}