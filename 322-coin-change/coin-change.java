class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[amount+1][coins.length];
        for(int[] a: dp){
            Arrays.fill(a,-1);
        }
        
        int res=ans(coins, amount, 0, dp);
        if(res==Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }
    public int ans(int[] coins, int amount, int ptr,
    int[][] dp){
        if(amount==0){
            return 0;
        }
        if(ptr==coins.length){
            return Integer.MAX_VALUE;
        }
        //take or leave it
        if(amount<0){
            return Integer.MAX_VALUE;
        }
        if(dp[amount][ptr]!=-1){
            return dp[amount][ptr];
        }
        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;

        if(amount-coins[ptr]>=0){
            a=ans(coins, amount-coins[ptr], ptr, dp);
            if(a!=Integer.MAX_VALUE){
                a+=1;
            }
            b=ans(coins, amount-coins[ptr], ptr+1, dp);
            if(b!=Integer.MAX_VALUE){
                b+=1;
            }
        }
        int c=ans(coins, amount, ptr+1, dp);
        
        return dp[amount][ptr]=Math.min(a,Math.min(b,c));
    }
}