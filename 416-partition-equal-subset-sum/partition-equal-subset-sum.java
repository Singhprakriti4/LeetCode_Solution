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

        int[][] dp=new int[nums.length+1][(totalsum/2)+1];



        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;//when sum==0 return true;
        }
        for(int i=1;i<dp[0].length;i++){
            dp[nums.length][i]=0;//false when we reach the last index and our sum is still not equal to 0
        }

        for(int row=nums.length-1;row>=0;row--){
            //starting from the last index(valid)
            for(int col=1;col<dp[0].length;col++){
                //
                if(col-nums[row]<0){
                    dp[row][col]=dp[row+1][col];//without considering current nums[i]
                }
                else{
                    dp[row][col]=Math.max(dp[row+1][col], dp[row+1][col-nums[row]]);
                }
            }
        }

        return dp[0][totalsum/2]==1;

    }
}