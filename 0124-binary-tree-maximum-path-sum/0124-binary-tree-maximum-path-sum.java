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
    int maxi=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findmaxpath(root);
        return maxi;
    }
    private int findmaxpath(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftsum=Math.max(0,findmaxpath(node.left));
        int rightsum=Math.max(0,findmaxpath(node.right));

        int currentpathsum=node.val+leftsum+rightsum;

        maxi=Math.max(maxi,currentpathsum);
        return node.val + Math.max(leftsum,rightsum);
    }
}