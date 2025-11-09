class Solution {
    public int minCost(int n, int[] cuts) {
        // int[][] dp=new int[n+1][n+1];
        HashMap<String, Integer> map=new HashMap<>();
        // for(int i=0;i<dp.length;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        return helper(cuts,0,n,map);
    }
    public int helper(int[] cuts, int s, int e, HashMap<String, Integer> map){
        // if(cuts[0])
        String k=s+":"+e;
        if(map.containsKey(k)){
            return map.get(k);
        }
        // if(dp[s][e]!=-1){
        //     return dp[s][e];
        // }

        int ans=Integer.MAX_VALUE;
        int add=e-s;

        for(int i=0;i<cuts.length;i++){
            if(cuts[i]>s && cuts[i]<e){
                //we have to cut
                int curr=add+helper(cuts,s,cuts[i],map)+helper(cuts,cuts[i],e,map);
                ans=Math.min(ans, curr);
            }
        }

        if(ans==Integer.MAX_VALUE){
            //nothing to be cut here i.e no cuts found
            // return dp[s][e]=0;
            map.put(k,0);
            return 0;
        }

        // return dp[s][e]=ans;
        map.put(k,ans);
        return ans;
    }
}