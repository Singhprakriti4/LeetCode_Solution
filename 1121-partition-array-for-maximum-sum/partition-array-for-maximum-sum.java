class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[][] dp=new int[arr.length][k+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return maxsum(arr, 0, k, dp);
    }
    public int maxsum(int[] arr, int s, int k, int[][] dp){
        if(s==arr.length){
            return 0;
        }
        if(dp[s][k]!=-1){
            return dp[s][k];
        }
        int ans=0;
        int currmaxval=-1;
        for(int i=s;i<s+k;i++){
            if(i>=arr.length) break;

            currmaxval=Math.max(currmaxval,arr[i]);
            int currlen=i-s+1;
            int currans=currlen*currmaxval + maxsum(arr, i+1, k, dp);

            ans=Math.max(ans,currans);
        }
        return dp[s][k]=ans;
    }
}