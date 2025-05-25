class Solution {
    //memoised approach 
    public int longestPalindromeSubseq(String s) {
        int[][] dp=new int[s.length()][s.length()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return subseq(0,s.length()-1,s,dp);
    }
    public int subseq(int i, int j, String s, int[][] dp){
        if(i>j){
            return 0;
        }
        if(i==j){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
            dp[i][j]=2+subseq(i+1,j-1,s,dp);
        }
        else{
            dp[i][j]=Math.max(subseq(i+1,j,s,dp),subseq(i,j-1,s,dp));
        }
        return dp[i][j];
    }
}