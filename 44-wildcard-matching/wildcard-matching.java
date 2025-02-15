class Solution {
    public boolean isMatch(String s, String p) {
        int [][] dp=new int[s.length()][p.length()];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int i= match(0,0,s,p,dp);
        if(i==0){
            return false;
        }
        return true;

    }
    public int match(int i, int j, String s, String p,int[][] dp){
        if(i==s.length() && j==p.length()){
            return 1;
        }
        if(i==s.length() && j!=p.length()){
            for(int k=j;k<p.length();k++){
                if(p.charAt(k)!='*'){
                 return 0;
                }
            }
            return 1;
        }
        
        if(i>=s.length() || j>=p.length()) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if((s.charAt(i)==p.charAt(j)) || p.charAt(j)=='?'){
           return dp[i][j] =match(i+1,j+1,s,p,dp);
        }
        else if(p.charAt(j)=='*'){
         return dp[i][j]=Math.max(match(i+1,j,s,p,dp),match(i,j+1,s,p,dp));
        }
        return dp[i][j]=0;
    }
}