class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return profit(nums, nums.length-1,dp);
    }
    public int profit(int[] nums, int curr, int[] dp){
        if(curr<0){
            return 0;
        }

        if(dp[curr]!=-1){
            return dp[curr];
        }
       
        return dp[curr]= Math.max(nums[curr]+profit(nums,curr-2,dp),
                        profit(nums,curr-1,dp));
        //maximum of choosing to rob the curr house or not
    }
}