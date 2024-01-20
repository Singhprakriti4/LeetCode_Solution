class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int c=0;
        for(int i=0;i<=nums.length-1;i++){
           for (int j=0;j<nums.length-i-1;j++){
                   if(nums[j]>nums[j+1]){
                       int temp=nums[j];
                       nums[j]=nums[j+1];
                       nums[j+1]=temp;
                   }
            }
        }
        for(int k=0;k<nums.length-1;k++){
            if(nums[k]==nums[k+1]){
                c++;
            }
            else{
                c=0;
            }
            if(c>=nums.length/2){
               return  nums[k];
            }
        }
        return -1;
    }
}