class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(text1, text2, text1.length()-1, text2.length()-1,dp);
    }
    public int func(String s1, String s2, int i, int j,int[][] dp){
        if(i==-1 || j==-1){
            return 0;
        }
        if(dp[i+1][j+1]!=-1){
            return dp[i+1][j+1];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i+1][j+1]=1+func(s1,s2,i-1,j-1,dp);
        }

        return dp[i+1][j+1]=Math.max(func(s1,s2,i,j-1,dp),func(s1, s2, i-1,j,dp));
    }
}