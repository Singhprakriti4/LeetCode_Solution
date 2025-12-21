class Solution {
    public String longestPalindrome(String s) {
        int len=0;
        String ans="";

        boolean[][] dp=new boolean[s.length()][s.length()];
        dp[s.length()-1][s.length()-1]=true;
        len=1;
        ans=s.substring(s.length()-1);

        for(int i=s.length()-2;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(i==j){
                    dp[i][j]=true;
                }
                else if(s.charAt(i)==s.charAt(j)){
                    if(i==1 && j==2){
                    System.out.println("hi");
                }
                    int pi=i+1;
                    int pj=j-1;
                    // if(pi>pj)
                    if(pi>pj || (pi<=pj && dp[pi][pj]==true)){
                        dp[i][j]=true;
                    }
                }
                
                // if(i==1 && j==2){
                //     System.out.println(dp[i][j]);
                // }
                
                int curr=j-i+1;
                if(dp[i][j]){
                    if(curr>len){
                        len=curr;
                        ans=s.substring(i,j+1);
                    }
                }
            }
        }
        return ans;
    }
}