class Solution {
    public int findMin(int[] nums) {

        int s=0;
        int e=nums.length-1;
        int ans=Integer.MAX_VALUE;

        while(s<=e){
           int m=s+(e-s)/2;
           ans=Math.min(ans,nums[m]);
           if(nums[m]>nums[e]){
            s=m+1;
           }
           else{
            e=m-1;
           }
        }

        return ans;

    }
}