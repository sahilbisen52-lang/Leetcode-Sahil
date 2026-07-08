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
        StringBuilder sb=new StringBuilder();
        buildstring(root,sb);
        return (sb.toString());
     }
     private void buildstring(TreeNode node,StringBuilder sb){
        if(node==null){
            sb.append("N,");
            return;
        }
        sb.append(node.val).append(",");
        buildstring(node.left,sb);
        buildstring(node.right,sb);
     }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue= new LinkedList<>(Arrays.asList(data.split(",")));
        return buildtree(queue);
     }
     private TreeNode buildtree(Queue<String> queue){
        String currentval=queue.poll();
        if(currentval.equals("N")){
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(currentval));
        node.left=buildtree(queue);
        node.right=buildtree(queue);
        return node;
     }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));