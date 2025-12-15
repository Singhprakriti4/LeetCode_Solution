class Solution {
    public boolean canJump(int[] nums) {

        int[] dp=new int[nums.length];
        // dp[nums.length]=0;
        dp[nums.length-1]=1;

        for(int i=dp.length-2;i>=0;i--){
            //go for jump
            for(int jump=1;jump<=nums[i];jump++){
                if(i+jump<nums.length){
                    if(dp[i+jump]==1){
                        dp[i]=1;
                        break;
                    }
                }
                else{
                    break;
                }
            }
        }
        return dp[0]==1;
    //     int[] dp=new int[nums.length];
    //     Arrays.fill(dp,-1);
    //     //-1:null, 0:false, 1:true
    //    return jump(nums,0,dp);     
    // }
    // public boolean jump(int[] nums, int i, int[] dp){
    //     if(i>=nums.length){
    //         return false;
    //     }
    //     if(i==nums.length-1){
    //         return true;
    //     }
    //     if(dp[i]!=-1){
    //         if(dp[i]==0) return false;
    //         return true;
    //     }
    //     boolean ans=false;
    //     for(int jump=1;jump<=nums[i];jump++){
    //         ans= ans || jump(nums, i+jump, dp);
    //     }
    //     if(ans==true){
    //         dp[i]=1;
    //     }
    //     else{
    //         dp[i]=0;
    //     }
    //     return ans;
    }
}