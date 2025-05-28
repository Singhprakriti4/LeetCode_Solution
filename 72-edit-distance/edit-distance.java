class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<word1.length()+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(word1, 0, word2, 0, dp);
        // return -1;
    }
    public int func(String s1, int i, String s2, int j, int[][] dp){
        //base case
        if(i==s1.length() && j==s2.length()){
            return 0;
        }
        if(j==s2.length() && i!=s1.length()){
            //delete the remaining char from s1
            return s1.length()-i;
        }
        if(i==s1.length() && j!=s2.length()){
            //add remaining cgar in s1
            return s2.length()-j;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int ans=Integer.MAX_VALUE;
        if(s1.charAt(i)==s2.charAt(j)){
            ans= func(s1, i+1, s2, j+1, dp);
        }
        else{
            //deletion
            ans=Math.min(ans, 1+func(s1, i+1, s2, j, dp));
            //replace
            ans=Math.min(ans, 1+func(s1, i+1, s2, j+1, dp));
            //insert
            ans=Math.min(ans, 1+func(s1, i, s2, j+1, dp));
        }
        
        dp[i][j]=ans;
        return ans;
    }
}