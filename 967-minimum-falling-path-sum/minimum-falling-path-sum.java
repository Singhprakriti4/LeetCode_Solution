class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans=Integer.MAX_VALUE;
        int m=matrix.length;
        int n=matrix[0].length;

        for(int i=0;i<n;i++){
            int[][] dp=new int[m][n];
            for(int j=0;j<m;j++)
            Arrays.fill(dp[j],Integer.MAX_VALUE);

            ans=Math.min(ans,minpathsum(matrix,m,n,0,i,dp));
        }

        return ans;
    }
    public int minpathsum(int[][] matrix, int m, int n, int r, int c, int[][] dp){
        if(r==m-1){
            //reached the last row
            return matrix[r][c];
        }

        if(dp[r][c]!=Integer.MAX_VALUE){
            return dp[r][c];
        }

        int ans=Integer.MAX_VALUE;
        if(r+1<m ){
            ans=Math.min(ans, matrix[r][c]+minpathsum(matrix,m,n,r+1,c,dp));//down
        }
        if(r+1<m && c+1<n){
            ans=Math.min(ans, matrix[r][c]+minpathsum(matrix,m,n,r+1,c+1,dp));//diagonally right
        }
        if(r+1<m && c-1>=0){
            ans=Math.min(ans, matrix[r][c]+minpathsum(matrix,m,n,r+1,c-1,dp));//diagonally left
        }

        return dp[r][c]=ans;
    }
}