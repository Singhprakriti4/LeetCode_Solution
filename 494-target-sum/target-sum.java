class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[] count={0};
        sum(nums,target,0,count,0);
        return count[0];
    }
    public void sum(int[] nums,int target,int ptr,int[] count,int value){
        if(ptr==nums.length){
            if(value==target){
                count[0]++;
            }
            return;
        }
       sum(nums,target,ptr+1,count,value-nums[ptr]);
       sum(nums,target,ptr+1,count,value+nums[ptr]);
       
    }
}