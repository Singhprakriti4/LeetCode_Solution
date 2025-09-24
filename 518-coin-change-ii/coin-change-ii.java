class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length+1][amount+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(coins,coins.length-1,amount,dp);
    }
    public int func(int[] coin,int idx, int amount, int[][] dp){
        if(amount==0){
            return 1;
        }
        if(idx==-1){
            return 0;
        }

        if(dp[idx+1][amount]!=-1){
            return dp[idx+1][amount];
        }
        //takable
        if(coin[idx]<=amount){
            return dp[idx+1][amount]=func(coin,idx,amount-coin[idx],dp)+func(coin,idx-1,amount,dp);
        }

        return func(coin,idx-1,amount,dp);
    }
}