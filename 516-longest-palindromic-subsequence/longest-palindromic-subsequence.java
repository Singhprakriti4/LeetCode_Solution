class Solution {
    public int longestPalindromeSubseq(String s) {
        int[] dp=new int[s.length()];
        dp[s.length()-1]=1;
        int prev=0;//whatever value is being changed currently

        for(int i=s.length()-2;i>=0;i--){
            dp[i]=1;
            prev=0;
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    int temp=prev;
                    prev=dp[j];
                    dp[j]=temp+2;
                }
                else{
                    prev=dp[j];
                    dp[j]=Math.max(dp[j-1],dp[j]);
                }
            }
        }

        return dp[s.length()-1];
        // int[][] dp=new int[s.length()][s.length()];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         if(i>j){
        //             dp[i][j]=0;//invalid
        //         }
        //         if(i==j){
        //             dp[i][j]=1;//same character
        //         }
        //     }
        // }

        // for(int i=dp.length-1;i>=0;i--){
        //     for(int j=i+1;j<dp[0].length;j++){
        //         if(s.charAt(i)==s.charAt(j)){
        //             dp[i][j]=2+dp[i+1][j-1];
        //         }
        //         else{
        //             dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
        //         }
        //     }
        // }

        // return dp[0][s.length()-1];
        // int[][] dp=new int[s.length()][s.length()];
        // for(int i=0;i<dp.length;i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return lps(s,0,s.length()-1,dp);
    }
    // public int lps(String s, int i, int j, int[][] dp){
    //     if(i==j){
    //         return 1;
    //     }
    //     if(i>j){
    //         return 0;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     if(s.charAt(i)==s.charAt(j)){
    //         return dp[i][j]=2+lps(s,i+1,j-1,dp);
    //     }
        
    //     return dp[i][j]=Math.max(lps(s,i+1,j,dp),lps(s,i,j-1,dp));
    // }
}