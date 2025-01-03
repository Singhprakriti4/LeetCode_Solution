class Solution {
    public int waysToSplitArray(int[] nums) {
        int ans=0;
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        
        long curr=0;
        for(int i=0;i<nums.length-1;i++){
            curr+=nums[i];
            if(curr>=sum-curr){
                ans++;
            }
        }
        return ans;
    }
}