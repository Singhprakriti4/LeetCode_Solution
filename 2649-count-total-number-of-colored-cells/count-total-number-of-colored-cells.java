class Solution {
    public long coloredCells(int n) {
        long curr=0;
        long ans=0;
        for(int i=2;i<=n;i++){
            curr+=4;
            ans+=curr;
        }
        return ans+1;
    }
}