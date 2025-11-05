class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            dp[i][n]=Integer.MAX_VALUE;
        }
        for(int i=0;i<=n;i++){
            dp[m][i]=Integer.MAX_VALUE;
        }

        for(int row=m-1;row>=0;row--){
            for(int col=n-1;col>=0;col--){
                if(row==m-1 && col==n-1){
                    dp[row][col]=grid[row][col];
                    continue;
                }
                dp[row][col]=Math.min(dp[row+1][col],dp[row][col+1])+grid[row][col];
            }
        }

        return dp[0][0];
    }
}