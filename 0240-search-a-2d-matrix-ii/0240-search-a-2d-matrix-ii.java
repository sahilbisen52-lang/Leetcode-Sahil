class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int Rows=matrix.length;
        int Cols=matrix[0].length;
        int r=0;
        int c=Cols-1;

        while(r<Rows && c>=0){
            if(matrix[r][c]==target){
                return true;
            }
            else if(target<matrix[r][c]){
                c=c-1;
            }
            else{
                r=r+1;
            }
        }
        return false;
    }
}