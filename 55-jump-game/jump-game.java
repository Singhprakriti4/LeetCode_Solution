class Solution {
    public boolean canJump(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        //-1:null, 0:false, 1:true
       return jump(nums,0,dp);     
    }
    public boolean jump(int[] nums, int i, int[] dp){
        if(i>=nums.length){
            return false;
        }
        if(i==nums.length-1){
            return true;
        }
        if(dp[i]!=-1){
            if(dp[i]==0) return false;
            return true;
        }
        boolean ans=false;
        for(int jump=1;jump<=nums[i];jump++){
            ans= ans || jump(nums, i+jump, dp);
        }
        if(ans==true){
            dp[i]=1;
        }
        else{
            dp[i]=0;
        }
        return ans;
    }
}