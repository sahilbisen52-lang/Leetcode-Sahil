class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int provincescount=0;
        boolean[] visited=new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                provincescount++;
                dfs(isConnected,visited,i,n);
            }
        }
        return provincescount;
    }
    private void dfs(int[][] isConnected,boolean[] visited,int city,int n){
        visited[city]=true;
        for(int j=0;j<n;j++){
            if(isConnected[city][j]==1 && !visited[j]){
                dfs(isConnected,visited,j,n);
            }
        }
    }
}