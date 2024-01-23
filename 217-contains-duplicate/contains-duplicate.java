class Solution {
    public boolean containsDuplicate(int[] nums) {
        sortarray(nums,0,nums.length-1);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
    public void sortarray(int[] nums,int low,int high){
        if(low>=high){
            return;
        }
        int start=low;
        int end=high;

       int mid=start+(end-start)/2;
       int pivot= nums[mid];
       while(start<=end){
         while(nums[start]<pivot){
             start++;
         }
          while(nums[end]>pivot){
              end--;
          }
          if(start<=end){
              int temp=nums[start];
              nums[start]=nums[end];
              nums[end]=temp;
              start++;
              end--;
          }
        }
        sortarray(nums,low,end);
        sortarray(nums,start,high);
       
    }
}