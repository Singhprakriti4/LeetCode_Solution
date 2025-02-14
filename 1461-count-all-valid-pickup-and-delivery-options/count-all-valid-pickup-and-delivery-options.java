class Solution {
    public int countOrders(int n) {
        int mod=1000000007;
         long count=1;
        for(int i=2;i<n+1;i++){
            int poss=2*i-1;
            int total=poss*(poss+1)/2;
            count=(count*total)%mod;
        }
        return (int)count;
    }
}



