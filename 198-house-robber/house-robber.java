class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return rob(nums,0,dp);
    }
    public int rob(int[] nums,int index,int[] dp){
        if(index>=nums.length){
            return 0;
        }
        if(dp[index]!=-1) return dp[index];
        dp[index]=Math.max(nums[index]+rob(nums,index+2,dp),
        rob(nums,index+1,dp));

        return dp[index];
    }
}