class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()][word2.length()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        int lcs=lcs(word1,word2,word1.length()-1,word2.length()-1,dp);

        return word1.length()+word2.length()-2*lcs;
    }
    public int lcs(String s1, String s2, int i, int j,int[][] dp){
        if(i==-1 || j==-1){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=1+ lcs(s1,s2,i-1,j-1,dp);
        }
        return dp[i][j]=Math.max(lcs(s1,s2,i-1,j,dp),lcs(s1,s2,i,j-1,dp));
    }
}