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
  int col;
  int row;

  Pair(TreeNode node, int col, int row){
    this.node = node;
    this.col = col;
    this.row = row;
  }

}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      Queue <Pair> Q = new LinkedList<>();
      TreeMap <Integer, TreeMap <Integer, PriorityQueue <Integer>>> map = new TreeMap<>();
      if(root == null) return res;
      Q.add(new Pair(root, 0, 0));

      while(!Q.isEmpty()){
        Pair item = Q.poll();
        TreeNode node = item.node;
        int col = item.col;
        int row = item.row;

        if(node.left != null) Q.add(new Pair(node.left, col-1, row+1));
        if(node.right != null) Q.add(new Pair(node.right, col+1, row+1));

        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, new PriorityQueue<>());
        map.get(col).get(row).add(node.val);
      }
    
    for(TreeMap <Integer, PriorityQueue <Integer>> item : map.values()){
      List <Integer> temp = new ArrayList<>();
      for(PriorityQueue <Integer> queue : item.values()){
        while(!queue.isEmpty()){
          temp.add(queue.poll());
        }
      }
      res.add(temp);
    }
  return res;
       
  }
}