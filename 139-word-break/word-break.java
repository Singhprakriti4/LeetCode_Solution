class Solution {
    //options: either match or move forward
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>();
        for(String w: wordDict){
            set.add(w);
        }
        int[][] dp=new int[s.length()][s.length()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        //-1: null, 0: false, 1: true
        return match(s, set, 0, 0, dp);
    }
    public boolean match(String str, Set<String> set,
     int s, int e, int[][] dp){
        if(e==str.length()-1){
            //if a match-> return true;
            if(set.contains(str.substring(s,e+1))){
                return true;
            }
            return false;
        }
        if(dp[s][e]!=-1){
            if(dp[s][e]==0) return false;
            return true;
        }
        boolean ans=false;
        //match 
        String curr=str.substring(s,e+1);
        if(set.contains(curr)){
            ans=ans || match(str, set, e+1, e+1, dp);
        }
        //mismatch
        ans=ans || match(str, set, s, e+1, dp);
        if(ans==true){
            dp[s][e]=1;
        }
        else{
            dp[s][e]=0;
        }
        return ans;

    }
}