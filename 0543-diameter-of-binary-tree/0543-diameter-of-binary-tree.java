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
    int maxi=0;
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return maxi;
    }
    private int getHeight(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftheight=getHeight(node.left);
        int rightheight=getHeight(node.right);

        maxi=Math.max(maxi,leftheight+rightheight);

        return Math.max(leftheight,rightheight)+1;
    }
}