class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp=new int[s.length()][s.length()];
        for(int [] r: dp){
            Arrays.fill(r,-1);
        }
        return count(0,s.length()-1,dp,s);
    }
    public int count(int i, int j, int[][] dp , String s){
        if(i==j){
            return 1;
        }
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];

        if(s.charAt(i)==s.charAt(j)){
            dp[i][j]=2+count(i+1,j-1,dp,s);
        }
        else{
            dp[i][j]=Math.max(count(i+1,j,dp,s),count(i,j-1,dp,s));
        }
        return dp[i][j];
    }
}