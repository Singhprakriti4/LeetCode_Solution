class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[] dp=new int[nums.length];
        dp[0]=nums[0];//robbed the first house
        dp[1]=Math.max(nums[0],nums[1]);
        //cannot rob the last oone
        for(int i=2;i<nums.length-1;i++){
            dp[i]=Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        int ans=dp[nums.length-2];

        dp[0]=0;//did not rob the first house
        dp[1]=nums[1];
        //can rob the last one
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        ans=Math.max(ans, dp[nums.length-1]);
        return ans;
    }
}