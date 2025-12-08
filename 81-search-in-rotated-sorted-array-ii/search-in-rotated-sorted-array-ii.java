class Solution {
    public boolean search(int[] nums, int target) {
      int s=0;
      int e=nums.length-1;
      while(s<=e){
        int m=s+(e-s)/2;
        if(nums[m]==target){
            return true;
        }
        //if we are confused
        if(nums[s]==nums[m] && nums[m]==nums[e]){
            s+=1;
            e-=1;
        }
        else if(nums[m]>nums[e]){
            //left part is sorted
            if(target>=nums[s] && target<nums[m]){
                e=m-1;
            }
            else{
                s=m+1;
            }
        }
        else{
            //right part is sorted
            if(target>nums[m] && target<=nums[e]){
                s=m+1;
            }
            else{
                e=m-1;
            }
        }
      }  
      return false;
    }
}