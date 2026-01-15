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
class BSTIterator {
  Stack<TreeNode> stack = new Stack<>();

  public BSTIterator(TreeNode root) {
    // if(root == null) return null;
    TreeNode curr = root;
    stack.push(curr);
    while (curr.left != null) {
      stack.push(curr.left);
      curr = curr.left;
    }
  }

  public int next() {
    TreeNode item = stack.pop();
    if (item.right != null) {
      stack.push(item.right);
      Iterator(item.right);
    }
    return item.val;
  }

  private void Iterator(TreeNode node) {
    TreeNode curr = node;
    while (curr.left != null) {
      curr = curr.left;
      stack.push(curr);
    }
  }

  public boolean hasNext() {
    if (!stack.isEmpty()) {
      return true;
    }
    return false;
  }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */