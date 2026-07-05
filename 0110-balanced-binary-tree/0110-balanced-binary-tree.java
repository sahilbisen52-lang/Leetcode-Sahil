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
    boolean isBalanced=true;
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return isBalanced;
    }
    private int getHeight(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftheight=getHeight(node.left);
        int rightheight=getHeight(node.right);

        if(Math.abs(leftheight-rightheight)>1){
            isBalanced=false;
        }
        return Math.max(leftheight,rightheight)+1;
    }
}