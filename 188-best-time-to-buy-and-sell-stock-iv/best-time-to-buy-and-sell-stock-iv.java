class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp=new int[prices.length+1][k+1][2];
        //idx, chances left, bought(1) notbought(0)

        for(int i=0;i<k+1;i++){
            for(int j=0;j<2;j++){
                dp[prices.length][i][j]=0;//reached the end
            }
        }

        for(int i=0;i<=prices.length;i++){
            for(int j=0;j<2;j++){
                dp[i][0][j]=0;//if no chnaces left return 0
            }
        }

        for(int row=prices.length-1;row>=0;row--){
            for(int col=1;col<=k;col++){
                int trueval=1;
                int falseval=0;

                dp[row][col][falseval]=Math.max(dp[row+1][col][1]-prices[row],
                                                dp[row+1][col][0]);
                dp[row][col][trueval]=Math.max(dp[row+1][col-1][0]+prices[row],
                                               dp[row+1][col][1]);
            }
        }

        return dp[0][k][0];

        
    }
}