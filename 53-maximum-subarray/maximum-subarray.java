class Solution {
    public int maxSubArray(int[] nums) {
        int maxcurrsum=nums[0];
        int ans=nums[0];

        for(int i=1;i<nums.length;i++){
           
            maxcurrsum=Math.max(maxcurrsum+nums[i],nums[i]);
            ans=Math.max(ans,maxcurrsum);
        }
        // if(ans<0){
        //     return 0;
        // }
        return ans;
    }
}