class Solution {
    public int thirdMax(int[] nums) {
        //sort
        Arrays.sort(nums);
        int c=0;
       if(nums.length<3){
           return nums[nums.length-1];
       }
       else{
             for(int i=nums.length-1;i>=0;i--){
                 if(i==nums.length-1){
                     c++;
                 }
                 else if(nums[i]!=nums[i+1]){
                         c++;
                     
                 }
                 if(c==3){
                     return nums[i];
                 }
             }
       }
         
         return nums[nums.length-1];
    }
}