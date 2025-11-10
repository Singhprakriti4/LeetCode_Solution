class Solution {
    //note matrix chain multiplication me subproblems banti hain + they are independent

    public int maxCoins(int[] nums) {
        int[][] dp=new int[nums.length][nums.length];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return coins(nums,0,nums.length-1,dp);        
    }
    public int coins(int[] nums, int s, int e, int[][] dp){
        if(s>e){
            return 0;
        }
        if(dp[s][e]!=-1){
            return dp[s][e];
        }
        int ans=0;

        for(int i=s;i<=e;i++){
            int left=1;
            int right=1;
            if(s-1>=0){
                left=nums[s-1];
            }
            if(e+1<nums.length){
                right=nums[e+1];
            }
            int currprofit= (nums[i]*left*right)+
                            coins(nums,s,i-1,dp)+//left subproblem
                            coins(nums,i+1,e,dp);//right subproblem
            ans=Math.max(ans,currprofit);
        }

        return dp[s][e]=ans;
    }
}