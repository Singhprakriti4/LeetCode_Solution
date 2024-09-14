class Solution {
    public int longestSubarray(int[] nums) {
     int max_index=0;
     for(int i=0;i<nums.length;i++){
        if(nums[i]>nums[max_index]){
            max_index=i;
        }
     }
     int maxlength=1;
     if(max_index==nums.length-1){
        return maxlength;
     } 
     else{
        
        int j=max_index;
        while(j<nums.length){
           if(nums[j]==nums[max_index]){ 
            int start=j;
            while(j<nums.length && nums[j]==nums[max_index]){
                j++;
            }
            maxlength=Math.max(maxlength,j-start);
           }
           else{
              j++;
           }
        }
     }
     return maxlength;
    }
}
