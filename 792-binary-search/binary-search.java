class Solution {
    public int search(int[] nums, int target) {
     
       int start=0;
       int end=nums.length-1;
       return binarysearch(start,end,nums,target);
    }
    int binarysearch(int start, int end, int[] arr, int target){
      if(start>end){
            return -1;
        }
      int mid=start+(end-start)/2;
      if(arr[mid]==target){
        return mid;
      }
      else if(arr[mid]>target){
       return binarysearch(start,mid-1,arr,target);
      }
      else{ return binarysearch(mid+1,end,arr,target);}
    }
}