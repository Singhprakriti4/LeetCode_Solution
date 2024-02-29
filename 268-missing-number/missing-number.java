class Solution {
    public int missingNumber(int[] nums) {
       int range=nums.length;
       for(int i=0;i<nums.length;i++){
           if(nums[i]!=i){
               for(int j=i;j<nums.length;j++){
                   if(nums[j]==i){
                       int temp=nums[i];
                       nums[i]=nums[j];
                       nums[j]=temp;
                   }
               }
               if(nums[i]!=i){
                   return i;
               }
               
           }
       }
       return range; 
    }
}