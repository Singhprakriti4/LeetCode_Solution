class Solution {
    //pattern feels like 0/1 knapsack
    //m and n act as the weights and the no of zeros and ones for each 
    //indivisula string are the prices. 
    public int findMaxForm(String[] strs, int m, int n) {
        //map stores the no of 0s and 1s for each index (key-> index, value-> {noofzeros, noofones})
        HashMap<Integer,int[]> map=new HashMap<>();

        for(int i=0;i<strs.length;i++){
            int zeros=0;
            int ones=0;
            for(int idx=0;idx<strs[i].length();idx++){
                if(strs[i].charAt(idx)=='0'){
                    zeros+=1;
                }
                else{
                    ones+=1;
                }
            }
            map.put(i,new int[]{zeros,ones});
        }


        int[][][] dp=new int[strs.length][m+1][n+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<m+1;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(strs, strs.length-1, m, n, map, dp);

    }
    public int helper(String[] strs, int idx, int m, int n,
    HashMap<Integer,int[]> map, int[][][] dp){
        if(idx==-1){
            return 0;
        }
        if(dp[idx][m][n]!=-1){
            return dp[idx][m][n];
        }
        //take the curr value or not
        int[] counts=map.get(idx);
        int zeros=counts[0];
        int ones=counts[1];
        if(m-zeros>=0 && n-ones>=0){
            //take or leave
            int take=1+helper(strs, idx-1, m-zeros, n-ones, map, dp);
            int leave=helper(strs, idx-1, m, n, map, dp);

            return dp[idx][m][n]=Math.max(take, leave);
        }

        //curr value cannot be taken we have no option

        return dp[idx][m][n]=helper(strs, idx-1, m, n, map, dp);

    }
}