class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp=new int[s.length()+1][p.length()+1];
        //0-> not calculated
        //1-> true
        //2-> false
        return match(0, 0, s, p, dp);
    }
    public boolean match(int i, int j, String s, String p, int[][] dp){

        if(i==s.length() && j==p.length()) {
            // System.out.println(s.charAt(i-1)+" "+p.charAt(j-1));
            return true;
        }

        if(i==s.length() && j!=p.length()){
           
            if(p.charAt(j)=='*') 
            {    
                
                return match(i, j+1, s, p, dp);
            }
            else
            { 
                
                return false;
            }
        }

        if(i!=s.length() && j==p.length()) return false;

        if(dp[i][j]!=0){
            if(dp[i][j]==1) return true;
            else return false;
        }

        if(p.charAt(j)!='?' && p.charAt(j)!='*'){
           
            if(s.charAt(i)!=p.charAt(j)){
                //  System.out.println(s.charAt(i)+" "+p.charAt(j));
                dp[i][j]=2;
                 return false;
            }
            else{
            boolean res= match(i+1, j+1, s, p, dp);
            if(res==true) dp[i][j]=1;
            else dp[i][j]= 2;
            return res;
            }
        }

        if(p.charAt(j)=='?'){
            // System.out.println(s.charAt(i)+" "+p.charAt(j));
            boolean res=match(i+1, j+1, s, p, dp); 
            if(res==true) dp[i][j]=1;
            else dp[i][j]=2;
            return res;
        }
        
        if(p.charAt(j)=='*'){
            boolean ans=false;
            //try all different combinations
            for(int leap=0; leap<=s.length()-i; leap++){
                ans=ans || match( i+leap, j+1, s, p, dp);
            }

            if(ans==true) {
                dp[i][j]=1;
                return ans;
            }

        }
        
        dp[i][j]=2;
        return false;
    }
}