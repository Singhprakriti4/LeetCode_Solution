class Solution {
    int mod=1000000007;
    public int countPermutations(int[] complexity) {
       for(int i=1;i<complexity.length;i++){
        if(complexity[i]<=complexity[0]){
            return 0;
        }
       }
       return (int)fact(complexity.length-1);
    }
    public long fact(int n){
        if(n<=1){
            return 1;
        }
        return (n*(fact(n-1)%mod))%mod;
    }
}