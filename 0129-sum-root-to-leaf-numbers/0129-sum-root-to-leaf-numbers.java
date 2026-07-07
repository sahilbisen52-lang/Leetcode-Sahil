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
    public int sumNumbers(TreeNode root) {
        return calculatesumpath(root,0);
    }
    private int calculatesumpath(TreeNode node,int oldnumber){
        if(node==null){
            return 0;
        }
        int newnumber=(oldnumber*10)+(node.val);
        if(node.left==null && node.right==null){
            return newnumber;
        }
        int leftpath=calculatesumpath(node.left,newnumber);
        int rightpath=calculatesumpath(node.right,newnumber);

        return leftpath+rightpath;
    }
}