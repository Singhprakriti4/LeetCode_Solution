class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans= {-1,-1};
        ans[0]=binary(nums,target,true);
        if(ans[0]!=-1){
            ans[1]=binary(nums,target, false);
        }
        return ans;

    }
    int binary(int[] nums,int target, boolean starting){
        int ans=-1;
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]>target){
                end=mid-1;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
                if(starting){
                  ans=mid;
                  end=mid-1;
                }
                else{
                    ans=mid;
                    start=mid+1;
                }
            }
        }
        return ans;
    }
}