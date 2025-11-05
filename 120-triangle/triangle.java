class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int[][] dp=new int[m][m];

        for(int i=0;i<m;i++){
            //keeping last row as teh same
            dp[m-1][i]=triangle.get(m-1).get(i);
        }

        for(int row=m-2;row>=0;row--){
            // int k=row;
            for(int col=row;col>=0;col--){
                dp[row][col]=Math.min(dp[row+1][col],dp[row+1][col+1])+triangle.get(row).get(col);
            }
        }

        return dp[0][0];
    }
}