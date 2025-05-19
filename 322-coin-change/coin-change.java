class Solution {
    //memoised approach
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,-1);
        int res=minvalue(coins,amount,dp);

        if(res!=Integer.MAX_VALUE) return res;

        return -1;
    }
    public int minvalue(int[] coins, int amount,int[] dp){
        if(amount==0) return 0;

        if(amount<0) return Integer.MAX_VALUE;
        
        if(dp[amount]!=-1) return dp[amount];

        int ans=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
         int res=minvalue(coins, amount-coins[i],dp);
         if(res!=Integer.MAX_VALUE){
            ans=Math.min(ans,1+res);
         }
        }

        dp[amount]=ans;
        return ans;
    }
}