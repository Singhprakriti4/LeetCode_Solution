class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }

        return noofways(obstacleGrid, m, n, 0, 0, dp);
    }
    public int noofways(int[][] grid, int m, int n, int r, int c, int[][] dp){
        if(r>=m || c>=n || grid[r][c]==1){
            return 0;
        }
        if(r==m-1 && c==n-1){
            return 1;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }

        int move1=noofways(grid, m, n, r+1, c, dp);//down
        int move2=noofways(grid, m, n, r, c+1, dp);//right

        return dp[r][c]=move1+move2;
    }
}