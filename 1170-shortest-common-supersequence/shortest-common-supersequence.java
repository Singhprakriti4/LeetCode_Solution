class Solution {
   
    public String shortestCommonSupersequence(String str1, String str2) {

        String[] dp=new String[str2.length()+1];
        
        for(int j=0;j<dp.length;j++){
            dp[j]=str2.substring(j,str2.length());
        }
         for(int i=str1.length()-1;i>=0;i--){
            
            //initialisation of value of j (last idx of each row)
            String prev=dp[str2.length()];
            dp[str2.length()]=str1.substring(i,str1.length());
            //value of dp[i+1][j+1]
            
            for(int j=str2.length()-1;j>=0;j--){
                String temp = dp[j];
                if(str1.charAt(i)==str2.charAt(j)){
                    dp[j]=str1.charAt(i)+ prev;
                }
                else{
                    String s1=str1.charAt(i)+dp[j];
                    String s2=str2.charAt(j)+dp[j+1];
                    if(s1.length()<s2.length()){
                        dp[j]=s1;
                    }
                    else{
                        dp[j]=s2;
                    }
                }
                prev=temp;
            }
        }
        
        return dp[0];
    }
}