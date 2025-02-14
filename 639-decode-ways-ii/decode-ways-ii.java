class Solution {
    static int mod=1000000007;
    public int numDecodings(String s) {
       long[] dp=new long[s.length()] ;
       Arrays.fill(dp,-1);
       return (int)decode(s,dp,0);

    }
    public long decode(String s,long[] dp, int i){
        if(i>=s.length()){
            return 1;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        long ways=0;
        if(s.charAt(i)=='0'){
            return 0;
        }

        if(s.charAt(i)=='*'){
            //single digit consideration
            ways=(9*decode(s,dp,i+1))%mod;

            //double digit consideration
            if(i+2<=s.length()){
                if(s.charAt(i+1)!='*'){
                  int digit=s.charAt(i+1)-'0';
                  if(digit<=6){
                    ways=(ways%mod+2*decode(s,dp,i+2)%mod)%mod;
                  }
                  else{
                    ways=(ways%mod+decode(s,dp,i+2)%mod)%mod;
                  }
                }
                else{
                  ways=(ways%mod+15*decode(s,dp,i+2)%mod)%mod;
                }
            }
        }
        else{
            //if it is a digit
            ways=decode(s,dp,i+1)%mod;

            if(i+2<=s.length()){
                if(s.charAt(i+1)!='*'){
                    //check for 26 wala condition
                    int num=Integer.valueOf(s.substring(i,i+2));
                    if(num>0 && num<27){
                        ways=(ways%mod+decode(s,dp,i+2)%mod)%mod;
                    }
                    
                }
                else{
                    int val=s.charAt(i)-'0';
                    if(val==1){
                        ways=(ways%mod+9*decode(s,dp,i+2)%mod)%mod;
                    }
                    if(val==2){
                        ways=(ways%mod+6*decode(s,dp,i+2)%mod)%mod;
                    }
                }
            }
             
        }
        dp[i]=ways;
        return dp[i];

    }
    
}