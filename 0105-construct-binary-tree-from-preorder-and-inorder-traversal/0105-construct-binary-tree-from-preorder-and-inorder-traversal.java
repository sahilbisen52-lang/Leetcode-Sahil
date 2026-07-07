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
    int preindex=0;
    int inindex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,Integer.MIN_VALUE);
    }
    private TreeNode build(int[] preorder,int[] inorder,int stopvalue){
        if(preindex==preorder.length || inorder[inindex]==stopvalue){
        return null;
        }
        TreeNode root=new TreeNode(preorder[preindex++]);

        root.left=build(preorder,inorder,root.val);
        inindex++;

        root.right=build(preorder,inorder,stopvalue);

        return root;
    }
}