class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums[0]<k){
            return -1;
        }
        int curr=nums[nums.length-1];
        int ans=0;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<curr){
                curr=nums[i];
                ans+=1;
            }
        }
        if(curr>k){
            ans+=1;
        }
        return ans;
    }
}