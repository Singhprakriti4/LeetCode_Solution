class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length+1][2];
        
        //initialisation
        for(int i=0;i<2;i++){
            dp[prices.length][i]=0;//we reached the last case
        }

        for(int row=prices.length-1;row>=0;row--){
            int truecol=1;
            int falsecol=0;

            dp[row][falsecol]=Math.max(-prices[row]+dp[row+1][1],
                                       dp[row+1][0]);

             int val=prices[row];
             if(row+2<=prices.length){
                val+=dp[row+2][0];
             }

             dp[row][truecol]=Math.max(val, dp[row+1][1]);
        }

        return dp[0][0];

    }
}