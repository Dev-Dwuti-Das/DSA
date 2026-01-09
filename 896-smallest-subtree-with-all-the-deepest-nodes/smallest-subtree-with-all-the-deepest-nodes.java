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
  public TreeNode subtreeWithAllDeepest(TreeNode root) {
       if(root == null) return null;
      Queue <TreeNode> Q = new LinkedList<>();
      List<List<TreeNode>> res = new ArrayList <>();
      Q.offer(root);
      while(!Q.isEmpty()){
        List <TreeNode> temp = new ArrayList<>(); 
        int size = Q.size();
        for(int i = 0; i < size; i++){
          TreeNode item = Q.poll();
          temp.add(item);
          if(item.left != null) Q.offer(item.left);
          if(item.right != null) Q.offer(item.right);
        }
        res.add(temp);
      }
      TreeNode p = res.get(res.size()-1).get(0);
      TreeNode q = res.get(res.size()-1).get(res.get(res.size()-1).size()-1);
      return lca(root, p, q);
  }

  public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null)
      return null;
    if (root == p || root == q)
      return root;

    TreeNode left = lca(root.left, p, q);

    TreeNode right = lca(root.right, p, q);

    if (left == null && right == null) {
      return null;
    } else if (left != null && right == null) {
      return left;
    } else if (left == null && right != null) {
      return right;
    } else
      return root;
  }
}
