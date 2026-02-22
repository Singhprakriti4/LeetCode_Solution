class Solution {
    public boolean checkValidString(String s) {
        int[][][] dp=new int[s.length()+1][s.length()+1][s.length()+1];
        for(int ptr=0;ptr<dp.length;ptr++){
            dp[s.length()][ptr][ptr]=1;
        }
        
        for(int i=s.length()-1;i>=0;i--){
            for(int j=s.length()/2;j>=0;j--){
                for(int k=j;k>=0;k--){
                    if(s.charAt(i)=='('){
                        dp[i][j][k]=dp[i+1][j+1][k];
                    }
                    else if(s.charAt(i)==')'){
                        dp[i][j][k]=dp[i+1][j][k+1];
                    }
                    else{
                        int one=dp[i+1][j][k+1];
                        int two=dp[i+1][j+1][k];
                        int three=dp[i+1][j][k];

                        dp[i][j][k]=Math.max(one, Math.max(two, three));
                    }
                }
            }
        }
        if(dp[0][0][0]==1){
            return true;
        }
        return false;
        // return valid(s,0,0,0,dp);
    }
    // public boolean valid(String s, int idx,int open, 
    // int close, int[][][] dp){

    //     if(close>open || close>s.length()/2
    //     || open>s.length()/2 ) return false;

    //     if(idx==s.length()){
    //         if(open==close){
    //             return true;
    //         }
    //         return false;
    //     }

    //     if(dp[idx][open][close]!=0){
    //         if(dp[idx][open][close]==1){
    //             return true;
    //         }
    //         return false;
    //     }

    //     if(s.charAt(idx)=='('){
    //         boolean res=valid(s,idx+1,open+1,close,dp);
    //         if(res){
    //             dp[idx][open][close]=1;
    //         }
    //         else{
    //             dp[idx][open][close]=2;
    //         }
    //         return res;
    //     }
    //     else if(s.charAt(idx)==')'){
    //         boolean res=valid(s,idx+1,open,close+1,dp);
    //         if(res){
    //             dp[idx][open][close]=1;
    //         }
    //         else{
    //             dp[idx][open][close]=2;
    //         }
    //         return res;
    //     }
    //     boolean val=valid(s,idx+1,open+1,close,dp)||valid(s,idx+1,open,close+1,dp)||valid(s,idx+1,open,close,dp);
    //     if(val){
    //             dp[idx][open][close]=1;
    //         }
    //         else{
    //             dp[idx][open][close]=2;
    //         }
    //         return val;
    // }
}