class Solution {
    public int minCut(String s) {
        int[][] dp=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        boolean[][] isPal=precomputePalindromes(s);

        // for(int i=dp.length-1;i>=0;i--){
        //     for(int j=0;j<dp[0].length;j++){
        //         if(i>j || isPal[i][j]){
        //              dp[i][j]=0;
        //         }
        //         else{
        //             int ans=Integer.MAX_VALUE;
        //             for(int idx=i;idx<j;idx++){
        //             int curr=1+dp[i][idx];
        //             if(idx+1<=j){
        //                 curr+=dp[idx+1][j];
        //             }
        //             ans=Math.min(ans,curr);
        //         }
        //         dp[i][j]=ans;
        //         }

        //     }
        // }
        return helper(s,0,s.length()-1,dp,isPal);
        // return dp[0][s.length()-1];
    }
    public int helper(String s, int i, int j,int[][] dp,
    boolean[][] isPal){

        if(i>j || isPal[i][j]){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;

        for(int idx=i;idx<j;idx++){
            if(isPal[i][idx]){
            int curr=1+helper(s,i,idx,dp,isPal)+helper(s,idx+1,j,dp,isPal);
            ans=Math.min(ans, curr);
            }
        }

        return dp[i][j]=ans;
    }
    // public boolean isPal(String s, int i, int j){
    //     int l=i;
    //     int r=j;
    //     while(l<=r){
    //         if(s.charAt(l)!=s.charAt(r)) return false;
    //         l++;
    //         r--;
    //     }
    //     return true;
    // }
    public boolean[][] precomputePalindromes(String s) {
    int n = s.length();
    boolean[][] isPal = new boolean[n][n];

    for (int i = n - 1; i >= 0; i--) {
        for (int j = i; j < n; j++) {
            if (s.charAt(i) == s.charAt(j)) {
                if (j - i <= 2) {
                    isPal[i][j] = true;
                } else {
                    isPal[i][j] = isPal[i + 1][j - 1];
                }
            }
        }
    }
    return isPal;
}

}