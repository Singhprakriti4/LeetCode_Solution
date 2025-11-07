class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[amount+1][coins.length];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-2);
        }
        return noofcoins(coins, amount, coins.length-1,dp);
    }
    public int noofcoins(int[] coins, int amt, int idx, int[][] dp){
        if(amt==0){
            return 0;//number of coins 
        }
        if(idx==-1 || amt<0){
            return -1;//cannot be taken
        }
        if(dp[amt][idx]!=-2){
            return dp[amt][idx];
        }
        int takecoin=noofcoins(coins, amt-coins[idx], idx,dp);
        int leavecoin=noofcoins(coins, amt, idx-1,dp);

        if(takecoin==-1 && leavecoin==-1){
            //cannot be taken in any case
            return  dp[amt][idx]=-1;
        }
        else if(takecoin==-1){
            //leavecoin func is feasible
            return dp[amt][idx]= leavecoin;
        }
        else if(leavecoin==-1){
            //takecoin is feasible
            return dp[amt][idx]= 1+takecoin;
        }
        

        return dp[amt][idx]= Math.min(1+takecoin,leavecoin);

    }
   
}