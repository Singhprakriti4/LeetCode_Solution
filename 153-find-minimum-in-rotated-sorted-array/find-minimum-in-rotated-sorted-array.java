class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
       if(nums[0]<nums[nums.length-1]){
        return nums[0];
       } 
       if(nums[0]>nums[1]){
        return nums[1];
       }
       if(nums[nums.length-1]<nums[nums.length-2]){
        return nums[nums.length-1];
       }
       int start=0;
       int end=nums.length-1;
       while(start<=end){
        int mid=start+(end-start)/2;
        if(nums[mid]>nums[mid-1]){
            if(nums[mid]>nums[nums.length-1]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        else{
            return nums[mid];
        }
       }
       return -1;
    }
}