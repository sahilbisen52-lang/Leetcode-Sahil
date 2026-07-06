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
    public boolean isValidBST(TreeNode root) {
        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean validate(TreeNode node,long minRange,long maxRange){
        if(node==null){
        return true;
        }
        if(node.val<=minRange || node.val>=maxRange){
            return false;
        }
        boolean isLeftValid=validate(node.left,minRange,node.val);
        boolean isRightValid=validate(node.right,node.val,maxRange);

        return isLeftValid && isRightValid;
    }
}