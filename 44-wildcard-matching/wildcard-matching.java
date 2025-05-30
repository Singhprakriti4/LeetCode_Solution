class Solution {
    public boolean isMatch(String s, String p) {

        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        
        int n=s.length();
        int m=p.length();

        //initialization
        dp[n][m]=true;
        for(int i=0;i<n;i++){
            dp[i][m]=false;
        }
        for(int i=m-1;i>=0;i--){
            if(p.charAt(i)!='*'){
                dp[n][i]=false;
            }
            else{
               dp[n][i]=dp[n][i+1];
            }
        }

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(p.charAt(j)!='?' && p.charAt(j)!='*'){
                    //surely a character
                    if(s.charAt(i)!=p.charAt(j)){
                        dp[i][j]=false;
                    }
                    else{
                        dp[i][j]=dp[i+1][j+1];
                    }
                }
                if(p.charAt(j)=='?'){
                    dp[i][j]=dp[i+1][j+1];
                }
                if(p.charAt(j)=='*'){

                    //iterate on each possibility
                    for(int leap=i;leap<=n;leap++){
                        if(dp[leap][j+1]==true){
                            dp[i][j]=true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[0][0];
    }
}