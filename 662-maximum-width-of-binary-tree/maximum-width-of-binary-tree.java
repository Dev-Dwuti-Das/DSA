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
class Pair{
  TreeNode node;
  int idx;
  Pair(TreeNode root, int col){
    this.node = root;
    this.idx = col;
  }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
      int res = 0;
      Queue <Pair> Q = new LinkedList<>();
      if(root == null) return 0;
      Q.offer(new Pair(root, 0));
      
      while(!Q.isEmpty()){
        int left = 0;
        int right = 0;
        int size = Q.size();
        int min = Q.peek().idx;
        for(int i = 0; i < size; i++){
          Pair item = Q.poll();
          int index = item.idx - min;
          if(i == 0) left = index;
          if(i == size-1) right = index;
          if(item.node.left != null) Q.offer(new Pair(item.node.left, 2*index+1));
          if(item.node.right != null) Q.offer(new Pair(item.node.right, 2*index+2));
        }

      res = Math.max(res, right - left + 1);
      }
    return res;
    }
}