class Solution {
    public int coinChange(int[] coin, int amount) {
        int[][] dp=new int[coin.length+1][amount+1];
        for(int i=1;i<dp[0].length;i++){
            dp[0][i]=Integer.MAX_VALUE;
        }

        for(int idx=1;idx<dp.length;idx++){
            for(int a=1;a<=amount;a++){
                if(coin[idx-1]<=a){
                    int take=dp[idx][a-coin[idx-1]];
                    if(take!=Integer.MAX_VALUE)
                    take+=1;

                    dp[idx][a]=Math.min(take,dp[idx-1][a]);
                }
                else{
                    dp[idx][a]=dp[idx-1][a];
                }

            }
        }
        int ans=dp[coin.length][amount];
        if(ans==Integer.MAX_VALUE){
            return -1;
        }

        return ans;
    }
   
}