class Solution {
    //optimisation, let us count the numner of P after the count of chairs==2, then we multiply the result with it
    int mod=1000000007;
    public int numberOfWays(String corridor) {
        int[] dp=new int[corridor.length()];
        Arrays.fill(dp,-1);
        return ways(corridor,0, dp);
    }
    public int ways(String corridor, int idx, int[] dp){
        if(idx==corridor.length()){
            return 1;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        long ans=0;
        //from current to the end
        boolean foundanyway=false;
        int countofchairs=0;
        int countP=0;
        for(int i=idx;i<corridor.length();i++){
            if(corridor.charAt(i)=='S'){
                countofchairs+=1;
            }
            if(countofchairs>2){
                break;
            }
            else if(countofchairs==2){
                foundanyway=true;
                if(corridor.charAt(i)=='P'){
                    //agr lastP ke baad length aa gyi to add only once
                    countP+=1;
                    if(i+1==corridor.length() || 
                       corridor.charAt(i+1)=='S'){
                        //we found the last P of the current valid series
                        int r=ways(corridor, i+1, dp)%mod;
                        if(i+1==corridor.length()){
                            //the ans will be counted only once
                            ans=ans+r;
                            ans=ans%mod;
                        }
                        else{
                        countP+=1;//P creates two options to divide
                        ans=ans+(1L*countP*r)%mod;
                        ans=ans%mod;
                        }
                       }
                }
                else if(i+1==corridor.length() || 
                        corridor.charAt(i+1)=='S'){
                            //curr valid series does not have any P afterwards
                            ans=ans+ways(corridor, i+1, dp)%mod;
                            ans=ans%mod;
                        }
                //we need to call it only at the last "P"
                // ans=ans+(ways(corridor, i+1, dp))%mod;
                // ans=ans%mod;
            }
        }
        if(!foundanyway){
            return dp[idx]=0;
        }
        return dp[idx]= (int)ans;
    }
}