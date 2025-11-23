class Solution {
    public int maxSumDivThree(int[] nums) {
      int[][] dp=new int[nums.length][3];
      for(int i=0;i<dp.length;i++){
        if(i==0){
            int m=nums[i]%3;
            dp[i][m]=nums[i];
        }
        else{
            //add the currelemnt to all the prev ones to see
            //where it fits the best
            int m=(nums[i]+dp[i-1][0])%3;
            dp[i][m]=nums[i]+dp[i-1][0];
            m=(nums[i]+dp[i-1][1])%3;
            dp[i][m]=Math.max(dp[i][m], nums[i]+dp[i-1][1]);
            m=(nums[i]+dp[i-1][2])%3;
            dp[i][m]=Math.max(dp[i][m], nums[i]+dp[i-1][2]);
            
            for(int j=0;j<3;j++){
                dp[i][j]=Math.max(dp[i][j], dp[i-1][j]);
            }
        }
      }  

      return dp[nums.length-1][0];
    }
}