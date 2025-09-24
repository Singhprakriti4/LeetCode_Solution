class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length+1][amount+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
                }

        for(int idx=1;idx<dp.length;idx++){
            for(int a=1;a<dp[0].length;a++){
                if(coins[idx-1]<=a){
                    dp[idx][a]=dp[idx][a-coins[idx-1]]+dp[idx-1][a];
                }
                else{
                    dp[idx][a]=dp[idx-1][a];
                }
            }
        }
        // return func(coins,coins.length-1,amount,dp);
        return dp[dp.length-1][dp[0].length-1];
    }
}