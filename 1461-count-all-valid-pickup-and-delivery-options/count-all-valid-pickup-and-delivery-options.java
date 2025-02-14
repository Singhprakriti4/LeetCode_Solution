// class Solution {
//     public int countOrders(int n) {
//         int mod=1000000007;
//         int[] dp=new int[n+1];
//         int ans=1;
//         for(int i=2;i<n+1;i++){
//             int poss=2*i-1;
//             int total=poss*(poss+1)/2;
//             ans=(ans*total)%mod;
//         }
//         return ans;
//     }
// }
public class Solution {
    public int countOrders(int n) {
        int MOD = 1000000007;

        long count = 1;
        for (int i = 2; i <= n; i++) {
            count = (count * (2 *(i-1)+ 1) * i) % MOD;
        }
        return (int) count;
    }
}

