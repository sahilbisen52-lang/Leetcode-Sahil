class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        int numislands=0;
        int rows=grid.length;
        int cols=grid[0].length;
        
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
            if(grid[r][c]=='1'){
                numislands++;
                sinkislandDFS(grid,r,c,rows,cols);
            }
            }
        }
        return numislands;
    }
    private void sinkislandDFS(char[][] grid,int r,int c,int rows,int cols){
        if(r<0 || c<0 || r>=rows || c>=cols || grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';
        sinkislandDFS(grid,r+1,c,rows,cols);
        sinkislandDFS(grid,r-1,c,rows,cols);
        sinkislandDFS(grid,r,c+1,rows,cols);
        sinkislandDFS(grid,r,c-1,rows,cols);
    }
}