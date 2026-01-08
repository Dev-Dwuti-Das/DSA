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
  public void helper(TreeNode root, Map <TreeNode, TreeNode> map){
      Queue <TreeNode> Q = new LinkedList<>();
      Q.add(root);
      while(!Q.isEmpty()){
        TreeNode item = Q.poll();

        if(item.left != null) {
          Q.add(item.left);
          map.put(item.left, item);
        }

        if(item.right != null){
          Q.add(item.right);
          map.put(item.right, item);
        } 
      }
    }

public TreeNode helper2(TreeNode root, int start) {
    if (root == null || root.val == start) return root;

    TreeNode left = helper2(root.left, start);
    if (left != null) return left;

    return helper2(root.right, start);
}


  public int amountOfTime(TreeNode root, int start) {
    Map<TreeNode, TreeNode> map = new HashMap<>(); //child , parent
    helper(root, map);
    Set<TreeNode> set = new HashSet<>();
    Queue<TreeNode> Q = new LinkedList<>();
    TreeNode findnode = helper2(root, start);
    Q.add(findnode);
    int k = 0;
    set.add(findnode);
    while (!Q.isEmpty()) {
      k++;
      int size = Q.size();
      for (int i = 0; i < size; i++) {
        TreeNode item = Q.poll();

        if (item.left != null && set.add(item.left)) {
          Q.add(item.left);
        }

        if (item.right != null && set.add(item.right)) {
          Q.add(item.right);
        }

        if(map.get(item) != null && set.add(map.get(item))){
          Q.add(map.get(item));
        }
      }
    }
    return k-1;
  }
}