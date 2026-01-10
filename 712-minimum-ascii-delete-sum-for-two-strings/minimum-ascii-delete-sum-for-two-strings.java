class Solution {
    int sum;
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        dp[s1.length()][s2.length()]=0; //initialisation

        for(int r=s1.length()-1;r>=0;r--){
            int c=s2.length();
            //s2 end ho gaya hai s1 abhi bacha hua hai
            dp[r][c]=dp[r+1][c]+(int)s1.charAt(r);
        }
        for(int c=s2.length()-1;c>=0;c--){
            int r=s1.length();
            //s1 end ho gaya hai s2 abhi bhi bacha hua hai
            dp[r][c]=dp[r][c+1]+(int)s2.charAt(c);
        }

// fill karenge
        for(int i=s1.length()-1;i>=0;i--){
            for(int j=s2.length()-1;j>=0;j--){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=dp[i+1][j+1];
                }
                else{
                    int v=dp[i+1][j+1]+(int)s1.charAt(i)+(int)s2.charAt(j);
                    v=Math.min(v, dp[i][j+1]+(int)s2.charAt(j));
                    v=Math.min(v, dp[i+1][j]+(int)s1.charAt(i));
                    dp[i][j]=v;
                }
            }
        }

        // sum=Integer.MAX_VALUE;
        // // HashMap<
        // chardelete(s1, s2, 0, 0, 0);
        // return sum;
        return dp[0][0];
    }
    // public void chardelete(String p, String q, int i, int j, int curr){
    //     if(i==p.length() && j==q.length()){
    //         //we reached the end
    //         sum=Math.min(curr, sum);
    //         return ;
    //     }
    //     else if(i==p.length()){
    //         //q abhi b bacha hua hai
    //         chardelete(p, q, i, j+1, curr+(int)q.charAt(j));
    //         return;
    //     }
    //     else if(j==q.length()){
    //         chardelete(p, q, i+1, j, curr+(int)p.charAt(i));
    //         return;
    //     }

    //     if(p.charAt(i)==q.charAt(j)){
    //         //move forward
    //         chardelete(p, q, i+1, j+1, curr);
    //     }
    //     else{
    //         // delete both
    //         chardelete(p, q, i+1, j+1, curr+(int)p.charAt(i)+(int)q.charAt(j));
    //         //delete only first
    //         chardelete(p, q, i+1, j, curr+(int)p.charAt(i));
    //         //delete the second only
    //         chardelete(p, q, i, j+1, curr+(int)q.charAt(j));
    //     }
    // }
}