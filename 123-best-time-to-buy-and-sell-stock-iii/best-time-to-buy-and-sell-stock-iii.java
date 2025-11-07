class Solution {
    public int maxProfit(int[] prices) {

        int[][][] dp=new int[prices.length+1][3][2];
        //index, chnaces, bought(1) or not(0)

        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                dp[prices.length][i][j]=0;//when we reach the end of the array
            }
        }

        for(int i=0;i<prices.length+1;i++){
            for(int j=0;j<2;j++){
                dp[i][0][j]=0;//when chances are over
            }
        }

        for(int row=prices.length-1;row>=0;row--){//when row=prices.length, we have the ans already
            for(int col=2;col>=1;col--){//when chances==0 we have the ans alraedy
               int trueval=1;//bought a stock previously, want to sell
               int falseval=0;//did not buy

               dp[row][col][falseval]=Math.max(dp[row+1][col][1]-prices[row],
                                               dp[row+1][col][0]);

                dp[row][col][trueval]=Math.max(dp[row+1][col-1][0]+prices[row],
                                               dp[row+1][col][trueval]);
            }
        }
        
        return dp[0][2][0];
    }
}