class Solution {
    public boolean search(int[] nums, int target) {
         if(nums[0]<nums[nums.length-1]){
            return binary(nums,target,0,nums.length-1);
         }
         else{
            int pivot=-1;
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]>nums[i+1]){
                    pivot=i;
                }
            }
            return (binary(nums,target,0,pivot) || binary(nums,target,pivot+1,nums.length-1));
         }
       
    }
    boolean binary(int[] nums, int target,int start, int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return true;
            }
            else if(nums[mid]>target){
                end=mid-1;;
            }
            else{
                start=mid+1;
            }
        }
        return false;
    }
}