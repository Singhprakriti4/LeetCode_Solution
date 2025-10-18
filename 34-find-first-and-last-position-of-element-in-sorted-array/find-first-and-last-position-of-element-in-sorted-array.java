class Solution {
    public int[] searchRange(int[] nums, int target) {
       //first
       int s=0;
       int e=nums.length-1;
       int ansbeg=-1;
       int ansend=-1;

       while(s<=e){
        int m=s+(e-s)/2;
        if(nums[m]==target){
            ansbeg=m;
            e=m-1;
        }
        else if(nums[m]>target){
            e=m-1;
        }
        else{
            s=m+1;
        }
       } 

       //ending index
       s=0;
       e=nums.length-1;

       while(s<=e){
        int m=s+(e-s)/2;
        if(nums[m]==target){
            ansend=m;
            s=m+1;
        }
        else if(nums[m]>target){
            e=m-1;
        }
        else{
            s=m+1;
        }
       }

       return new int[]{ansbeg, ansend};
    }
}