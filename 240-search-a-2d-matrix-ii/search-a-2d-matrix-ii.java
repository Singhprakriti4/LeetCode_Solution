class Solution {
    public boolean searchMatrix(int[][] matrix, int target) { 

        // int r=matrix.length-1;
        // int c=matrix[0].length-1;

        // while(r>=0 && c>=0){
        //   if(matrix[r][c]==target) return true;
        //   if(matrix[r][0]>target) r--;
        //   if(matrix[0][c]>target) c--;
        // }
        // return false;

        int r=0;
        int c=matrix[0].length-1;
        while(r<matrix.length && c>=0){
            if(matrix[r][c]==target){
                return true;
            }
            if(matrix[r][c]>target) {
                c--;
            }
            else{
                r++;
            }
        }
        return false;
    }
}