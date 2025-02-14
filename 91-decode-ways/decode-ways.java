class Solution {
    public int numDecodings(String s) {
       int[] dp=new int[s.length()] ;
       Arrays.fill(dp,-1);
       return decode(s,dp,0);

    }
    public int decode(String s,int[] dp, int i){
        if(i==s.length()){
            return 1;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int ways=0;
        if(s.charAt(i)=='0') return 0;
        ways=decode(s,dp,i+1);
        if(i+1<s.length()){
            //26 check kr lo
            if(Integer.valueOf(s.substring(i,i+2))<27 && 
            Integer.valueOf(s.substring(i,i+2))>0){
                ways+=decode(s,dp,i+2);
             }
        }
        dp[i]=ways;
        return dp[i];

    }
    
}