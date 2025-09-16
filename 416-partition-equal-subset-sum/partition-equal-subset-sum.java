class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        
        //base case-> initialisation

        boolean[][] dp=new boolean[sum/2+1][nums.length+1];
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=true;
        }

        for(int s=1;s<dp.length;s++){
            for(int i=1;i<dp[0].length;i++){
                if(nums[i-1]<=s){
                    dp[s][i]=dp[s-nums[i-1]][i-1]|| dp[s][i-1];
                }
                else{
                    dp[s][i]=dp[s][i-1];
                }
            }
        }

        return dp[sum/2][nums.length];
    }
}