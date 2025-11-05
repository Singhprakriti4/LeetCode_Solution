class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }

        return minsum(grid, m, n, 0, 0, dp);
    }
    public int minsum(int[][] grid, int m, int n, int r, int c, int[][] dp){
        if(r==m-1 && c==n-1){
            return grid[r][c];
        }

        if(dp[r][c]!=-1){
            return dp[r][c];
        }

        int ans=Integer.MAX_VALUE;

        if(r+1<m)
        ans=Math.min(ans, grid[r][c] +minsum(grid, m, n, r+1, c, dp));

        if(c+1<n){
            ans=Math.min(ans, grid[r][c]+minsum(grid, m, n, r, c+1, dp));
        }

        return  dp[r][c]=ans;

    }
}