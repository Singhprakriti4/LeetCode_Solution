class Solution {
    public int waysToSplitArray(int[] nums) {
        int ans=0;
        long[] leftprefixsum=new long[nums.length];
        
        leftprefixsum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            leftprefixsum[i]=leftprefixsum[i-1]+nums[i];
        }

        for(int i=0;i<nums.length-1;i++){
         if(leftprefixsum[i]>=(leftprefixsum[nums.length-1]-leftprefixsum[i])){
            ans++;
         }
        }

        return ans;

    }
}