class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return ways(nums, target, nums.length-1);
    }
    public int ways(int[] nums, int target, int idx){
        if(idx==-1){
            //reached the last index
            if(target==0){
            return 1;
            }
            return 0;
        }

        return ways(nums,target-nums[idx],idx-1)+ways(nums, target+nums[idx], idx-1);

    }
}