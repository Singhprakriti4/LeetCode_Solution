class Solution {
    public int singleNonDuplicate(int[] nums) {
        int s=0;
        int e= nums.length-1;

        while(s<=e){
            int mid=s+(e-s)/2;
            if(mid+1<nums.length && nums[mid+1]==nums[mid]){
              if((mid+1+1)%2==0){
                s=mid+1;

              } 
              else{
                e=mid-1;
              } 
            }
            else if(mid-1>=0 && nums[mid-1]==nums[mid]){
                if((mid+1)%2==0){
                    s=mid+1;
                }
                else{
                    e=mid-1;
                }
            }
            else{
                return nums[mid];
            }
        }

        return -1;
    }
}