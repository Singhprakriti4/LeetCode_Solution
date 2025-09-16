class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;

        int[][] dp=new int[sum+1][nums.length+1];

        return ans(nums,sum/2,nums.length-1,dp);



    }
    public boolean ans(int[] nums, int sum, int idx, int[][] dp){
        if(sum==0){
                return true;
            }
        if(idx==-1){
            return false;
        }
        
        if(dp[sum][idx+1]!=0){
            if(dp[sum][idx+1]==1) return true;
            return false;
        }

        boolean  res =false;
        if(nums[idx]<=sum){
         res= ans(nums,sum-nums[idx],idx-1,dp) ||
               ans(nums,sum,idx-1,dp);
        }
        else{
            res=ans(nums,sum,idx-1,dp);
        }

        if(res){ dp[sum][idx+1]=1;
        }
        else{
            dp[sum][idx+1]=2;
        }
        return res;
    }
} 