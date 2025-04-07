class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        if(total%2!=0){
            return false;
        }
        int sum=total/2;
        //0>none
        //1> true
        //2> false

        int[][] dp=new int[nums.length][sum+1];
        return find(nums,0,0,sum,dp);
    }
    public boolean find(int[] nums,int idx, int curr, int sum,int[][] dp){
        if(idx==nums.length && curr==sum){
            return true;
        }
        if(idx==nums.length && curr!=sum){
            return false;
        }
        if(curr>sum) return false;
        
        if(dp[idx][curr]!=0){ 
            if(dp[idx][curr]==1) return true;
            if(dp[idx][curr]==2) return false;
        }
        //choice either put in sum1 or in sum2
        boolean f= find(nums,idx+1,curr+nums[idx],sum,dp);
        boolean s= find(nums,idx+1,curr,sum,dp);

        boolean res= f||s;
        if(res==true) dp[idx][curr]=1;
        else dp[idx][curr]=2;

        return res;
    }
}