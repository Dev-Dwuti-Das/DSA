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

class pair {
  TreeNode root;
  int level;

  public pair(TreeNode root, int level) {
    this.root = root;
    this.level = level;
  }
}

class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      if(root == null) return new ArrayList<>();

      List<List<Integer>> res = new ArrayList<>();
      Queue<pair> q = new LinkedList<>();
      q.offer(new pair(root, 0));

      while(!q.isEmpty()){
        int size = q.size();
        int num = q.peek().level;
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < size; i++){
          pair item = q.poll();
          TreeNode node = item.root;
          temp.add(node.val);
          int lvl = item.level;
          if(node.left != null) q.offer(new pair(node.left, lvl+1));
          if(node.right != null) q.offer(new pair(node.right, lvl+1));
        }
        if(num%2 != 0){
          Collections.reverse(temp);
        }
        res.add(temp);
      }
      return res;
    }
}