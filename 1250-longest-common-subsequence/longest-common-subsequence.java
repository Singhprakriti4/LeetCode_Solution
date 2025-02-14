class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
       int[][] dp=new int[text1.length()][text2.length()];
    for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
       return lcs(text1.length()-1,text2.length()-1,dp,text1,text2);

    }
    public int lcs(int i, int j, int[][] dp ,String s1,String s2){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            dp[i][j]=1+lcs(i-1,j-1,dp,s1,s2);
            
        }
        else{
            dp[i][j]=Math.max( lcs(i,j-1,dp,s1,s2) , lcs(i-1,j,dp,s1,s2));
        }
        return dp[i][j];
    }

    
}