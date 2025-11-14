class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp=new int[s.length()+1][t.length()+1];
    
        for(int i=0;i<dp[0].length;i++){
            dp[s.length()][i]=0;
        }
        for(int i=0;i<dp.length;i++){
            dp[i][t.length()]=1;
        }
        for(int i=dp.length-2;i>=0;i--){
            for(int j=dp[0].length-2;j>=0;j--){
                if(s.charAt(i)==t.charAt(j)){
                    dp[i][j]=dp[i+1][j+1]+dp[i+1][j];
                }
                else{
                    dp[i][j]=dp[i+1][j];
                }
            }
        }
        return dp[0][0];
        // return subseq(s,t,0,0);
    }
    // public int subseq(String s, String t, int i, int j){
    //     //base case
    //     if(j==t.length()){
    //         return 1;
    //     }
    //     if(i==s.length()){
    //         return 0;
    //     }

    //     if(s.charAt(i)==t.charAt(j)){
    //         return subseq(s,t,i+1,j+1)+subseq(s,t,i+1,j);
    //     }
    //     return subseq(s,t,i+1,j);
    // }
}