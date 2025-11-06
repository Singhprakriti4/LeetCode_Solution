class Solution {
    //intuition: every element can be put either in set1 or in set 2
    public boolean canPartition(int[] nums) {
        int totalsum=0;
        for(int i=0;i<nums.length;i++){
            totalsum+=nums[i];
        }
        if(totalsum%2==1){
            //odd number cannot be partitioned into 2
            return false;
        }

        int[][] dp=new int[nums.length][(totalsum/2)+1];
        for(int i=0;i<nums.length;i++)
        Arrays.fill(dp[i],-1);
        //0->false
        //1->true
        return equalsum(nums,0,totalsum/2,dp);
    }
    public boolean equalsum(int[] nums,int i,int sum, int[][] dp){
        if(sum==0){
            return true;
        }
        if(sum<0){
            return false;
        }
        if(i==nums.length){
            return sum==0;
        }
        if(dp[i][sum]!=-1){
            if(dp[i][sum]==0){
                return false;
            }
            return true;
        }

        boolean ans=equalsum(nums, i+1, sum-nums[i], dp) || equalsum(nums, i+1, sum, dp);
        if(ans){
             dp[i][sum]=1;
        }
        else{
            dp[i][sum]=0;
        }

        return ans;

    }
}