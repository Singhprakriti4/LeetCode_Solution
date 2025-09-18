class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       int range=0;
       for(int i=0;i<nums.length;i++){
        range+=nums[i];
       }
       if(Math.abs(target)>range || (target+range)%2==1) return 0;
    //    System.out.println(Math.abs(range-target)/2);
    int find=Math.abs(range+target)/2;
        int[][] dp=new int[nums.length+1][find+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return sum(nums,nums.length-1,find,dp);
    }
    public int sum(int[] nums,int ptr,int value,int[][] dp){
        if(ptr==-1){
            if(value==0){
                return 1;
            }
            return 0;
        }
        if(dp[ptr+1][value]!=-1){
            return dp[ptr+1][value];
        }
       if(nums[ptr]<=value){
        return dp[ptr+1][value]=sum(nums,ptr-1,value-nums[ptr],dp)+sum(nums,ptr-1,value,dp);
       }
       return dp[ptr+1][value]=sum(nums,ptr-1,value,dp);
    }
}