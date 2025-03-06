class Solution {
    //time complexity -n power 2
    public int longestPalindromeSubseq(String s) {

        //bottom up
        int[][]dp=new int[s.length()][s.length()];
        //initialize diagonals as 1

        for(int i=0;i<s.length();i++){
            dp[i][i]=1;
        }
        for(int col=1;col<dp.length;col++){
            int i=0;
            int j=col;
            while(i<dp.length && j<dp.length){
                if(s.charAt(i)==s.charAt(j) ){
                    
                    dp[i][j]=2+dp[i+1][j-1];
                    
                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
                i++;
                j++;
            }
        }
        return dp[0][s.length()-1];
    }
}