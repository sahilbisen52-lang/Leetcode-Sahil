class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // Helper function ko Root aur Level 0 ke sath bhej do
        dfs(root, 0, result);
        return result;
    }
    
    private void dfs(TreeNode node, int level, List<List<Integer>> result) {
        // Base Case: Agar hawa hai, toh wapas jao
        if (node == null) {
            return;
        }
        
        // Agar hum is level par pehli baar aaye hain, toh naya dibba banao
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        
        // Apne level wale dibbe mein apni value daal do
        result.get(level).add(node.val);
        
        // Left aur Right bacho ko agle level (level + 1) ke liye bhej do
        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
    }
}