class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
       int[] dp=new int[arr.length+1];
       dp[arr.length]=0;

       //idx represents the max no of subarrys starting fom the index idx
       for(int idx=dp.length-1;idx>=0;idx--){
        //we keep a track of maxcurrval and maxlength not exceeding k and 
        // the index not exceeding the arr.length

        int ans=0;
        int currmax=0;
        // int currans=0;

        for(int j=idx;j<idx+k;j++){

            if(j>=arr.length) break;

            currmax= Math.max(currmax, arr[j]);
            int currans=currmax*(j-idx+1)+dp[j+1];
            ans=Math.max(ans, currans);
        }

        dp[idx]=ans;
       }

       return dp[0];

        // int[]dp=new int[arr.length];
        // // for(int i=0;i<dp.length;i++){
        //     Arrays.fill(dp,-1);
        // // }
        // return maxsum(arr, 0, k, dp);
    }
    // public int maxsum(int[] arr, int s, int k, int[] dp){
    //     if(s==arr.length){
    //         return 0;
    //     }
    //     if(dp[s]!=-1){
    //         return dp[s];
    //     }
    //     int ans=0;
    //     int currmaxval=-1;

    //     for(int i=s;i<s+k;i++){
    //         if(i>=arr.length) break;

    //         currmaxval=Math.max(currmaxval,arr[i]);
    //         int currlen=i-s+1;
    //         int currans=currlen*currmaxval + maxsum(arr, i+1, k, dp);
    //         ans=Math.max(ans,currans);
    //     }
    //     return dp[s]=ans;
    // }
}