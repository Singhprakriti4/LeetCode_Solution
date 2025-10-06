class Solution {
    public int superEggDrop(int e, int f) {

        int[][] dp=new int[e+1][f+1];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return solve(e,f,dp);
    }
    public int solve(int e, int f, int[][] dp){
         if(e==1 || f==0 || f==1){
            return f;
        }
        if(dp[e][f]!=-1){
            return dp[e][f];
        }
        int mn=Integer.MAX_VALUE;
        int low=1;
        int high=f;

        while(low<=high){

            int k=(low+high)/2;
            int left,right;

            if(dp[e-1][k-1]!=-1){
                left=dp[e-1][k-1];
            }
            else{
                left=solve(e-1,k-1,dp);
            }
            if(dp[e][f-k]!=-1){
                right=dp[e][f-k];
            }
            else{
                right=solve(e,f-k,dp);
            }
            int tempans=1+Math.max(left,right);
            mn=Math.min(mn,tempans);

            if(left>right){
                // breaking wle part me zyada steps lg rhe so go down
                high=k-1;
            }
            else{
                low=k+1;
            }
        }
          return dp[e][f]=mn;
    }
}