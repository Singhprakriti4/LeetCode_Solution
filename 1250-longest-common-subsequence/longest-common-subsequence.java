class Solution {
    //recursion +memoisation
    
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()][text2.length()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return lcs(text1,text2,0,0,dp);
    }
    public int lcs(String s1, String s2, int i, int j,int[][] dp){
        if(i==s1.length() || j==s2.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j)){
            int consider=1+lcs(s1,s2,i+1,j+1,dp);
            ans=Math.max(ans, consider);
        }

        int option1=lcs(s1,s2,i+1,j,dp);
        int option2=lcs(s1,s2,i,j+1,dp);

        ans=Math.max(ans, Math.max(option1, option2));
        return dp[i][j]=ans;
    }
}