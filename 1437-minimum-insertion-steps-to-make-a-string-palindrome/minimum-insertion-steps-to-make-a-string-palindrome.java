class Solution {
    public int minInsertions(String s) {
        int[][] dp=new int[s.length()][s.length()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return inserts(s,0,s.length()-1,dp);
    }
    public int inserts(String s, int i, int j,int[][] dp){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=inserts(s,i+1,j-1,dp);
        }
        // System.out.println(s.charAt(i)+" "+s.charAt(j));
        return dp[i][j]=Math.min(1+inserts(s,i+1,j,dp),1+inserts(s,i,j-1,dp));
    }
}