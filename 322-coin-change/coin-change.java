class Solution {
    //bottom top approach

    public int coinChange(int[] coins, int amount) {

        int[] dp=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=0;i<dp.length;i++){

            for(int j=0;j<coins.length;j++){
               if(i-coins[j]>=0 && dp[i-coins[j]]!=Integer.MAX_VALUE){
                dp[i]= Math.min(dp[i],dp[i-coins[j]]+1);
               }
              
            }
            
        }
       
        if(dp[amount]!=Integer.MAX_VALUE) return dp[amount];

        return -1;
    }
}