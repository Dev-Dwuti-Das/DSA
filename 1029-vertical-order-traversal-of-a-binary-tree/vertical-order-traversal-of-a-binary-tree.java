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
    int col;

    Pair(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map =
            new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0, 0));

        while (!q.isEmpty()) {

            Pair item = q.poll();

            TreeNode node = item.node;
            int row = item.row;
            int col = item.col;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);

            if (node.left != null) {
                q.offer(new Pair(node.left, row + 1, col - 1));
            }

            if (node.right != null) {
                q.offer(new Pair(node.right, row + 1, col + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            List<Integer> curr = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) {

                while (!pq.isEmpty()) {
                    curr.add(pq.poll());
                }
            }

            res.add(curr);
        }

        return res;
    }
}