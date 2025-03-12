class Solution {
    public int maximumCount(int[] nums) {
     //find the last and first zero in the array
     int start=binary(nums,false);
     int end=binary(nums,true);

     int neg=start;
     int pos=nums.length-end-1;

     if(start==-1){
       start=findneg(nums)+1;
       if(start==-1){
        neg=0;
        pos=nums.length;
       }
       else{
         neg=start;
         pos=nums.length-neg;
       }
     }

     if(neg>pos){
        return neg;
     }
     return pos;

    }
    public int binary(int[] nums,boolean last){
        int s=0;
        int e=nums.length-1;
        int ans=-1;

        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]==0){
                ans=mid;
                if(last){
                    s=mid+1;
                }
                else{
                    e=mid-1;
                }
            }
            else if(nums[mid]<0){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return ans;
    }
    public int findneg(int[] nums){
        int s=0;
        int e=nums.length-1;
        int ans=-1;

        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]<0){
                ans=mid;
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return ans;
    }
}