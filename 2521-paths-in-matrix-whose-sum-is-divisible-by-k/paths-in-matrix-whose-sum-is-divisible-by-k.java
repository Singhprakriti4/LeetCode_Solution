class Solution {
    int mod=1000000007;
    public int numberOfPaths(int[][] grid, int k) {

        int m=grid.length;
        int n=grid[0].length;
        int[][][] dp=new int[m][n][k];

        int cm=grid[0][0]%k;
        dp[0][0][cm]=1;

        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                //go in all the rpev mods and see if the current one is a mtch
                //case one : top, case thwo: left
                if(r==0 && c==0) continue;
                for(int i=0;i<k;i++){

                    int row=r-1;
                    int col=c;
                    int currmod=(grid[r][c]+i)%k;
                    if(row>=0)
                    dp[r][c][currmod]=(dp[r][c][currmod]+dp[row][col][i])%mod;

                    row=r;
                    col=c-1;
                    if(col>=0)
                    dp[r][c][currmod]=(dp[r][c][currmod]+dp[row][col][i])%mod;
                }

            }
        }
        return dp[m-1][n-1][0];
    }
}