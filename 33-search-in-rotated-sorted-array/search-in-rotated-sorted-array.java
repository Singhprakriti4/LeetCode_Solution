class Solution {
    public int search(int[] nums, int target) {
       int start=0;
       int end=nums.length-1;
       while(start<=end){
        int mid=start+(end-start)/2;
        if(nums[mid]==target){
            return mid;
        }
        else if(nums[mid]>target){
            if(nums[end]>nums[start]){
                end=mid-1;
            }
            else{
               if(nums[mid]>nums[end]){
                //first half
                if(nums[0]<=target){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
               }
               else{
                //second half
                end=mid-1;
               }
            }
       }
       else{
        if(nums[start]<nums[end]){
            start=mid+1;
        }
        else{
           if(nums[mid]>nums[end]){
            //first half
            start=mid+1;
           }
           else{
            //second half
            if(nums[end]>=target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
           }
         }
       }
       } 
       return -1;
    }
}