class Solution {
    public boolean canJump(int[] nums) {
      int[] dp=new int[nums.length-1];
     return jump(nums,0,dp);
    }
    public boolean jump(int[] nums, int idx,int[] dp){
        if(idx==nums.length-1){
            return true;
        }
        
        if(dp[idx]!=0){
            if(dp[idx]==1) return true;
            else return false;
        }
        boolean ans=false;

        for(int i=1;i<=nums[idx];i++){
            boolean curr=jump(nums,idx+i,dp);

        if(curr) {
                dp[idx]=1;
                return true;
        }
        }
        
        dp[idx]=2;
        return ans;
    }
}