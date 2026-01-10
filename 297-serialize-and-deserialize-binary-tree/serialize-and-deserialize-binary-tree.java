/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    if (root == null)
      return "";
    Queue<TreeNode> Q = new LinkedList<>();
    Q.offer(root);
    while (!Q.isEmpty()) {
      int size = Q.size();
      for (int i = 0; i < size; i++) {
        TreeNode item = Q.poll();
        if (item == null) {
          sb.append("#"+",");
        } else {
          sb.append(item.val + ",");
          Q.offer(item.left);
          Q.offer(item.right);
        }
      }
    }
    System.out.print(sb);
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if(data.equals("")) return null;
    String[] values = data.split(",");
    TreeNode root = new TreeNode(Integer.parseInt(values[0]));
    Queue <TreeNode> Q =  new LinkedList<>();
    Q.offer(root);
    for(int i = 1; i < values.length; i++){
      TreeNode parent = Q.poll();
      if(!values[i].equals("#")){
        parent.left = new TreeNode(Integer.parseInt(values[i]));
        Q.add(parent.left);
      }
      if(!values[++i].equals("#")){
        parent.right = new TreeNode(Integer.parseInt(values[i]));
        Q.add(parent.right);
      }
    }
    return root;

  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));