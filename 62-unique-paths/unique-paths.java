class Solution {

    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];

        for(int i=0;i<=m-1;i++){
            dp[i][n-1]=1;
        }
        for(int i=0;i<=n-1;i++){
            dp[m-1][i]=1;
        }

        for(int row=m-2;row>=0;row--){
            for(int col=n-2;col>=0;col--){
                dp[row][col]=dp[row+1][col]+dp[row][col+1];
            }
        }

        return dp[0][0];
    }

}