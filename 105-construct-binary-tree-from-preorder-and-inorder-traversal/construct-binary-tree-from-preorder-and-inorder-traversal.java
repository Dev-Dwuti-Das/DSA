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
  int idx = 0;
  Map<Integer, Integer> map = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    for(int i = 0; i < inorder.length; i++){
      map.put(inorder[i], i);
    }
      return helper(preorder, inorder, 0 , inorder.length-1);
    }

  public TreeNode helper(int[] preorder, int[] inorder,int ins, int ine){
    if(ins > ine) return null;

    TreeNode tree = new TreeNode(preorder[idx++]);
    int mid = map.get(tree.val);
  

    tree.left = helper(preorder, inorder, ins, mid-1);
    tree.right = helper(preorder, inorder, mid+1, ine); 

    return tree;
  }
}