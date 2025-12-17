class Solution {
    public long maximumProfit(int[] prices, int k) {

      long[][] dp=new long[prices.length][k+1];
      long result=0; 
    
    for(int i=0;i<dp.length;i++){
        for(int j=0;j<dp[0].length;j++){
            if(j!=0){
                dp[i][j]=-1;
            }
        }
    }

    // dp[1][1]=Math.abs(prices[0]-prices[1]);

    for(int i=1;i<prices.length;i++){
        //goto eachprevious one
        //cas eone when we take the currnet index in consideration
        for(int j=i-1;j>=0;j--){
            long curr=Math.abs(prices[i]-prices[j]);
            if(j==0){
                // this will be the first transaction
                dp[i][1]=Math.max(dp[i][1], curr);
                result=Math.max(result, dp[i][1]);
            }
            else{
                //goto each of the value of k
                for(int trans=0;trans<k;trans++){
                    if(dp[j-1][trans]!=-1){
                        long val=curr+dp[j-1][trans];
                        dp[i][trans+1]=Math.max(dp[i][trans+1],
                        val);
                        result=Math.max(result, dp[i][trans+1]);
                    }
                    else{
                        break;
                    }
                }
            }
        }
        //cse 2: when i am not considering the current index
        for(int trans=1;trans<=k;trans++){
            dp[i][trans]=Math.max(dp[i][trans], dp[i-1][trans]);
            result=Math.max(result, dp[i][trans]);
        }
    }
    // for(int i=0;i<dp.length;i++){
    //     for(int j=0;j<dp[0].length;j++){
    //         System.out.print(dp[i][j]+" ");
    //     }
    //     System.out.println();
    // }
    // return 0;
    return result;
        }
    }
        // HashMap<String, Long> map=new HashMap<>();
    //     long[][][] dp=new long[k+1][prices.length][prices.length+1];
    //     for(int i=0;i<dp.length;i++){
    //         for(int j=0;j<prices.length;j++){
    //             Arrays.fill(dp[i][j],-1);
    //         }
    //     }
    //     return profit(prices, k, 0, prices.length, dp);
    // }
    // public long profit(int[] prices, int k, int idx, int previdx,  long[][][] dp){
    //     if(k==0 || idx==prices.length){
    //         return 0;
    //     }
    //     if(dp[k][idx][previdx]!=-1){
    //         return dp[k][idx][previdx];
    //     }
    //     long ans=0;
    //     if(previdx==prices.length){
    //         //buy-sell or leave the current state
    //         long buysell=profit(prices, k, idx+1, idx, dp);
    //         long leave=profit(prices, k, idx+1, prices.length, dp);
    //         ans=Math.max(ans, Math.max(buysell, leave));
    //     }
    //     else{
    //         if(prices[idx]>prices[previdx]){
    //             //sell or leave
    //             long sell=(prices[idx]-prices[previdx])+profit(prices, k-1, idx+1, prices.length, dp);
    //             long leave=profit(prices, k, idx+1, previdx, dp);
    //             ans=Math.max(ans, Math.max(sell, leave));
    //         }
    //         else if(prices[idx]<prices[previdx]){
    //             long buy=(prices[previdx]-prices[idx])+profit(prices, k-1, idx+1, prices.length, dp);
    //             long leave=profit(prices, k, idx+1, previdx, dp);
    //             ans=Math.max(ans, Math.max(leave, buy));
    //         }
    //     }
    //     // map.put(key, ans);
    //     return dp[k][idx][previdx]=ans;
    // }
// }