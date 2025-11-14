class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        String common=lcs(str1,str2);
        // System.out.println(common);
        int  i=0;
        int  j=0;
        int  k=0;
        StringBuilder sb=new StringBuilder();

        while(k<common.length()){
            if(str1.charAt(i)==common.charAt(k) && str2.charAt(j)==common.charAt(k)){
                sb.append(str1.charAt(i));
                i+=1;
                j+=1;
                k+=1;
            }
            else if(str1.charAt(i)==common.charAt(k)){
                sb.append(str2.charAt(j));
                j+=1;
            }
            else if(str2.charAt(j)==common.charAt(k)){
                sb.append(str1.charAt(i));
                i+=1;
            }
            else{
                //all 3 are distinct
                sb.append(str1.charAt(i));
                sb.append(str2.charAt(j));
                i+=1;
                j+=1;
            }
        }
        if(i<str1.length()){
            sb.append(str1.substring(i));
        }
        if(j<str2.length()){
            sb.append(str2.substring(j));
        }
        return sb.toString();
    }
    public String lcs(String s1, String s2 ){
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int idx=0;idx<dp.length;idx++){
            dp[idx][s2.length()]=0;//if we reached the end of string 2
        }
        for(int idx=0;idx<dp[0].length;idx++){
            dp[s1.length()][idx]=0;//if we reached the end of string 1
        }
        for(int i=dp.length-2;i>=0;i--){
            for(int j=dp[0].length-2;j>=0;j--){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=1+dp[i+1][j+1];
                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        StringBuilder ans=new StringBuilder();
        return makelcs(dp,0,0,s1,s2,ans);
    }
    public String makelcs(int[][] dp, int r, int c, String s1, String s2,
    StringBuilder sb){
        if(dp[r][c]==0){
            return sb.toString();
        }
        if(s1.charAt(r)==s2.charAt(c)){
            return makelcs(dp,r+1,c+1,s1,s2,sb.append(s1.charAt(r)));
        }
        else if(dp[r+1][c]==dp[r][c]){
            return makelcs(dp,r+1, c, s1, s2, sb);
        }
        return makelcs(dp,r,c+1,s1,s2,sb);
    }
}
