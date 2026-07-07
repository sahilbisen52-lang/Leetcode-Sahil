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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> finalans=new ArrayList<>();
        List<Integer> currentpath=new ArrayList<>();
        findPaths(root,targetSum,currentpath,finalans);
        return finalans;
    }
    private void findPaths(TreeNode node,int targetSum,List<Integer> currentpath,List<List<Integer>> finalans){
        if(node==null){
            return;
        }
        currentpath.add(node.val);
        int newtarget=targetSum-node.val;
        if(node.left==null && node.right==null && newtarget==0){
            finalans.add(new ArrayList<>(currentpath));
        }else{
            findPaths(node.left,newtarget,currentpath,finalans);
            findPaths(node.right,newtarget,currentpath,finalans);

        }
        currentpath.remove(currentpath.size()-1);

    }
}