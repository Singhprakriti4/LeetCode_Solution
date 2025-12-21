class Solution {
    public int countSubstrings(String s) {

        if(s.length()==0) return 0;

        boolean[][] dp=new boolean[s.length()][s.length()];
        dp[s.length()-1][s.length()-1]=true;
        int ans=1;

        for(int i=s.length()-2;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(i==j){
                    ans+=1;
                    dp[i][j]=true;
                }
                else if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j]=false;
                }
                else{
                    int previ=i+1;
                    int prevj=j-1;
                    // if(i==1 && j==2){
                        // System.out.println(previ+" "+prevj);
                    // }
                    if(previ>=prevj){
                        ans+=1;
                        dp[i][j]=true;
                    }
                    else{
                        dp[i][j]=dp[previ][prevj];
                        if(dp[i][j]) ans+=1;
                    }
                }
            }
        }
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp.length;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return ans;
    }
}