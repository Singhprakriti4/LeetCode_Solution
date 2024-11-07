class Solution {
    public int removeDuplicates(int[] nums) {
        int prev=0;
        int count=1;
        for(int next=0;next<nums.length;next++){
            if(nums[next]!=nums[prev]){
                prev++;
                nums[prev]=nums[next];
                count++;
            }
        }
        return count;
    }
}