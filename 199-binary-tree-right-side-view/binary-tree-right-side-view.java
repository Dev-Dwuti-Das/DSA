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

class Pair {
  TreeNode node;
  int row;

  Pair(TreeNode node, int row) {
    this.node = node;
    this.row = row;
  }
}

class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Queue<Pair> Q = new LinkedList<>();
    TreeMap<Integer, Stack<Integer>> map = new TreeMap<>();
    if (root == null)
      return res;
    Q.add(new Pair(root, 0));

    while (!Q.isEmpty()) {
      Pair item = Q.poll();
      TreeNode node = item.node;
      int row = item.row;
      if (node.left != null)
        Q.add(new Pair(node.left, row + 1));
      if (node.right != null)
        Q.add(new Pair(node.right, row + 1));
      map.putIfAbsent(row, new Stack<>());
      map.get(row).push(node.val);
    }

    for (Stack<Integer> item : map.values()) {
      res.add(item.pop());
    }

    return res;

  }
}