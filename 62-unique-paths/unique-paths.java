class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return noofways(m, n, 0, 0, dp);
    }
    public int noofways(int m, int n, int r, int c, int[][] dp){
        if(r<0 || r>=m || c<0 || c>=n){
            return 0;
        }
        if(r==m-1 && c==n-1){
            return 1;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        int path1=noofways(m, n, r+1, c, dp);//down
        int path2=noofways(m, n, r, c+1, dp);//right

        return dp[r][c]= path1+path2;
    }
}