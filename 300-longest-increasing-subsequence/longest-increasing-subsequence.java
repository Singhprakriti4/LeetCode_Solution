class Solution {

    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length][nums.length+1];
        for(int i=0;i<dp.length;i++){
        Arrays.fill(dp[i],-1);
        }

        return lis(nums,nums.length-1,-1,dp);
    }

    public int lis(int[] nums,int idx, int prev,int[][] dp){
        if(idx==-1){
            return 0;
        }

        if(dp[idx][prev+1]!=-1){
            return dp[idx][prev+1];
        }

        if(prev==-1 || nums[idx]<nums[prev] ){
            //take or leave
            return dp[idx][prev+1]=Math.max(lis(nums,idx-1,prev,dp),
                            1+ lis(nums,idx-1,idx,dp));
        }
        //cannot be taken
        return dp[idx][prev+1]=lis(nums,idx-1,prev,dp);
    }
}