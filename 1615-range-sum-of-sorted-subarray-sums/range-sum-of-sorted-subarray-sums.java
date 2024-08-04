class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {

        int[] sums=new int[n*(n+1)/2];
        int index=0;
        int mod=1000000007;
        int ans=0;

        for(int i=0;i<n;i++){
            int sub=0;
            for(int j=i;j<nums.length;j++){
               sub+=nums[j];
               sums[index]=sub;
               index++;
            }
            
        }

        Arrays.sort(sums);

        for(int i=left-1;i<right;i++){
            ans=(ans+sums[i])%mod;
        }
        
        if(ans<0){
            ans+=mod;
        }
        return ans;

    }
}