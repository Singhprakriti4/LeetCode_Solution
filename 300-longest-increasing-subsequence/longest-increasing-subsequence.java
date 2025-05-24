class Solution {
    public int lengthOfLIS(int[] nums) {

       int[] dp=new int[nums.length];
       int result=0;

       for(int i=0;i<nums.length;i++){
        int ans=1;
        for(int j=0;j<i;j++){
            if(nums[j]<nums[i]){
                ans=Math.max(ans,1+dp[j]);
            }
        }
        result=Math.max(result,ans);
        dp[i]=ans;
       } 
       
       return result;
    }
}