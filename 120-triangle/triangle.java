class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        
        int[][] dp=new int[m][m];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }

        return minval(triangle, m, 0, 0, dp);
    }
    public int minval(List<List<Integer>> triangle, int m, int r, int c, int[][] dp){
        if(r==m-1){
            //reached the last row
            return triangle.get(r).get(c);
        }

        if(dp[r][c]!=Integer.MIN_VALUE){
            return dp[r][c];
        }

        int path1=triangle.get(r).get(c)+minval(triangle, m, r+1, c, dp);
        int path2=triangle.get(r).get(c)+minval(triangle, m, r+1, c+1, dp);

        return dp[r][c]=Math.min(path1, path2);
    }
}