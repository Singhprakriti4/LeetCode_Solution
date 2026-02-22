class Solution {
    public boolean checkValidString(String s) {
        int[][][] dp=new int[s.length()][s.length()+1][s.length()+1];

        
        return valid(s,0,0,0,dp);
    }
    public boolean valid(String s, int idx,int open, 
    int close, int[][][] dp){

        if(close>open || close>s.length()/2
        || open>s.length()/2 ) return false;
        if(idx==s.length()){
            if(open==close){
                return true;
            }
            return false;
        }
        if(dp[idx][open][close]!=0){
            if(dp[idx][open][close]==1){
                return true;
            }
            return false;
        }

        if(s.charAt(idx)=='('){
            boolean res=valid(s,idx+1,open+1,close,dp);
            if(res){
                dp[idx][open][close]=1;
            }
            else{
                dp[idx][open][close]=2;
            }
            return res;
        }
        else if(s.charAt(idx)==')'){
            boolean res=valid(s,idx+1,open,close+1,dp);
            if(res){
                dp[idx][open][close]=1;
            }
            else{
                dp[idx][open][close]=2;
            }
            return res;
        }
        boolean val=valid(s,idx+1,open+1,close,dp)||valid(s,idx+1,open,close+1,dp)||valid(s,idx+1,open,close,dp);
        if(val){
                dp[idx][open][close]=1;
            }
            else{
                dp[idx][open][close]=2;
            }
            return val;
    }
}