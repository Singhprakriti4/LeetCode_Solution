class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp=new int[prices.length+1][2];
        for(int i=0;i<2;i++){
            dp[prices.length][i]=0;//base case initialisation
        }

        for(int row=prices.length-1;row>=0;row--){
            int bought=1;
            int notbought=0;

            dp[row][notbought]=Math.max(-prices[row]+dp[row+1][1], dp[row+1][0]);
            dp[row][bought]=Math.max(prices[row]-fee+dp[row+1][0], dp[row+1][1]);

        }

        return dp[0][0];

        // return profit(prices, fee, 0, false);
    }
    // public int profit(int[] prices, int fee, int idx, boolean bought){
    //     if(idx==prices.length){
    //         return 0;
    //     }

    //     if(!bought){
    //         int buynow=-prices[idx]+profit(prices, fee, idx+1, true);
    //         int notbuy=profit(prices, fee, idx+1, false);

    //         return Math.max(buynow, notbuy);
    //     }

    //     int sellnow=prices[idx]-fee+profit(prices, fee, idx+1, false);
    //     int notsell=profit(prices, fee, idx+1, true);

    //     return Math.max(sellnow, notsell);
    // }
}