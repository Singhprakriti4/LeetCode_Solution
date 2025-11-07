class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];

        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }
        return profit(prices, 0, false, dp);
    }
    public int profit(int[] prices,int idx, boolean bought,
    int[][] dp){
        // if(idx>prices.length)
        if(idx>=prices.length){
            return 0;
        }
        int j=0;
        if(bought) j=1;
        if(dp[idx][j]!=Integer.MIN_VALUE){

            return dp[idx][j];

        }

        if(!bought){
            int buynow=-prices[idx]+profit(prices, idx+1, 
            true, dp);
            int donotbuy=profit(prices, idx+1, false, dp);

            return dp[idx][j]=Math.max(buynow, donotbuy);
        }
       
        // int sellnow=0;
        // if(idx+2<=prices.length)
        int sellnow=prices[idx]+profit(prices, idx+2, false, dp);
        int donotsell=profit(prices, idx+1, true, dp);

        return dp[idx][j]=Math.max(sellnow, donotsell);

    }
}