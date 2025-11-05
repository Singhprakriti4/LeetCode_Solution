class Solution {
    //0-> true
    //1-> false

    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[][] dp=new int[nums.length][2];
        for(int i=0;i<dp.length;i++)
        Arrays.fill(dp[i],-1);
        return profit(nums, false, nums.length-1, dp);
    }
    public int profit(int[] nums, boolean first, int curr, int[][] dp){
        if(curr<0){
            return 0;
        }
        int j=0;
        if(!first) j=1;
        if(dp[curr][j]!=-1){
            return dp[curr][j];
        }
        if(curr==0){
            if(first){
                //if the first one was taken , can't take this one
                return dp[curr][j]=profit(nums, true, curr-1,dp);
            }
            else{
                return dp[curr][j]=Math.max(nums[curr]+profit(nums,true,curr-2,dp),
                                profit(nums, true, curr-1, dp));
            }
        }

        if(curr==nums.length-1){
            return dp[curr][j]=Math.max(nums[curr]+profit(nums, true, curr-2, dp),
            profit(nums,false, curr-1, dp));
        }

        return dp[curr][j]=Math.max(nums[curr]+profit(nums, first, curr-2, dp),
                       profit(nums, first, curr-1, dp));
    }
}