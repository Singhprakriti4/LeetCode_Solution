class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[amount+1][coins.length+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=-1;//if we donot have any coin
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=0;//amount is zero
        }
        
        for(int row=1;row<amount+1;row++){
            for(int col=1;col<=coins.length;col++){
               int take=-1;
               int leave=-1;
               if(row-coins[col-1]>=0){
                take=dp[row-coins[col-1]][col];
               }
               leave=dp[row][col-1];
               if(take==-1 && leave==-1){
                dp[row][col]=-1;
               }
               else if(take==-1){
                dp[row][col]=leave;
               }
               else if(leave==-1){
                dp[row][col]=1+take;
               }
               else{
                dp[row][col]=Math.min(1+take, leave);
               }
            }
        }

        return dp[amount][coins.length];

        // for(int i=0;i<dp.length;i++){
        //     Arrays.fill(dp[i],-2);
        // }
        // return noofcoins(coins, amount, coins.length-1,dp);
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
        int leavecoin=noofcoins(coins, amt, idx-1, dp);

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