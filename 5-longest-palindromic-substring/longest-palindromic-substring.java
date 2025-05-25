class Solution {
    public String longestPalindrome(String s) {
        
        boolean[][] dp=new boolean[s.length()][s.length()];
        String ans="";
        int len=0;
        
        // int end=0;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                dp[i][j]=true;
            }
        //   end+=1;  
        }
        
        int start=s.length()-1;

        for(int i=s.length()-2;i>=0;i--){

            for(int j=start;j<s.length();j++){

                // System.out.println("i:"+i+ " j:"+j);
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true){
                    dp[i][j]=true;
                }
                else{
                    dp[i][j]=false;
                }

                // anslogic
                if(dp[i][j]==true && j-i+1>len){
                    len=j-i+1;
                    ans=s.substring(i,j+1);
                }
            }
            start-=1;
        }

        if(len==0){
            return ""+s.charAt(0);
        }
        return ans;
        
    }
}