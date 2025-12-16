class Solution {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()+1];
        dp[s.length()]=1;//initialisation
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='0'){
                dp[i]=0;
            }
            else{
                dp[i]=dp[i+1];
                if(i+1<s.length()){
                    int curr=Integer.parseInt(s.substring(i,i+2));
                    if(curr>=1 && curr<=26){
                        dp[i]+=dp[i+2];
                    }
                }
            }
        }
        return dp[0];
    //    int[] dp=new int[s.length()];
    //    Arrays.fill(dp,-1);
    //    return decode(s,0,dp);
    // }
    // public int decode(String  s, int i, int[] dp){
    //     if(i==s.length()) {
    //         return 1;
    //     }
    //     if(dp[i]!=-1){
    //         return dp[i];
    //     }
    //     if(s.charAt(i)=='0'){
    //         return 0;
    //     }
    //     // if(dp[i])
    //     int ans=0;
    //     ans=decode(s, i+1, dp);
    //     if(i+1<s.length()){
    //     int next=Integer.parseInt(s.substring(i, i+2));
    //     if(next<=26 && next>=1){
    //         ans+=decode(s, i+2, dp);
    //     }
    //     }
    //     return dp[i]=ans;
    }
}