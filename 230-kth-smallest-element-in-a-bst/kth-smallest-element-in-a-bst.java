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
    public int kthSmallest(TreeNode root, int k) {
    Stack <TreeNode> stack = new Stack<>();
    TreeNode resnode = inorder(root, k, stack);    
    return resnode.val;
    }

    public TreeNode inorder(TreeNode root,int k, Stack <TreeNode> stack){
      if(root == null) return null;
      TreeNode node = root;
      TreeNode res = null;
      int z = 0;
      while(true){
        if(node != null){
          stack.push(node);
          node = node.left;
        }else{
          if(stack.isEmpty()){
            break;
          }
          TreeNode item = stack.pop();
          z++;
          if(z == k){
            res = item;
            break;
          }
          System.out.println(item.val);
          node = item.right;
        }
      } 
      return res;    
    }
}