class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int[] dp=new int[s2.length()+1];

        for(int i=1;i<s1.length()+1;i++){
            int temp=0;
            int prev=0;
            for(int j=1;j<dp.length;j++){
                temp=dp[j];
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[j]= 1 + prev;
                }
                else{
                    dp[j]= Math.max(dp[j],dp[j-1]); 
                }
                prev=temp;
            }
        }
        return dp[s2.length()];
    }
}