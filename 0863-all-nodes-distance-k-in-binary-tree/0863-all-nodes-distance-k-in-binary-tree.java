/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> result=new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findDistance(root,target,k);
        return result;
    }
    private int findDistance(TreeNode node, TreeNode target,int k){
        if(node==null){
            return -1;
        }
        if(node==target){
            addnotesdown(node,k);
            return 1;
        }
        int leftdistance=findDistance(node.left,target,k);
        if(leftdistance!=-1){
            if(leftdistance==k){
                result.add(node.val);
            }
            else{
                addnotesdown(node.right,k-leftdistance-1);
            }
            return leftdistance+1;
        }
        int rightdistance=findDistance(node.right,target,k);
        if(rightdistance!=-1){
            if(rightdistance==k){
                result.add(node.val);
            }
            else{
                addnotesdown(node.left,k-rightdistance-1);
            }
            return rightdistance+1;
        }
        return -1;
    }
    private void addnotesdown(TreeNode node,int distance){
        if(node==null || distance<0){
            return;
        }
        if(distance==0){
            result.add(node.val);
            return;
        }
        addnotesdown(node.left,distance-1);
        addnotesdown(node.right,distance-1);
    }
}