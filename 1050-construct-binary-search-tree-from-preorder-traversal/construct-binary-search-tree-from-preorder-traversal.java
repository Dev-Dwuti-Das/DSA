class Solution {

    int idx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {

        TreeNode root = new TreeNode(preorder[idx++]); // first element as root
        helper(preorder, Integer.MAX_VALUE, root);
        return root;
    }

    public void helper(int[] preorder, int UB, TreeNode root) {

        if (root == null || idx >= preorder.length) {
            return;
        }

        // LEFT child
        if (idx < preorder.length && preorder[idx] < root.val) {
            root.left = new TreeNode(preorder[idx++]);
            helper(preorder, root.val, root.left);
        } else {
            root.left = null;
        }

        // RIGHT child
        if (idx < preorder.length && preorder[idx] < UB) {
            root.right = new TreeNode(preorder[idx++]);
            helper(preorder, UB, root.right);
        } else {
            root.right = null;
        }
   
    }
}
