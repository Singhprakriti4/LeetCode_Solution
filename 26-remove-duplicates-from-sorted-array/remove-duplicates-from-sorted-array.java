class Solution {
    public int removeDuplicates(int[] nums) {
       int i=0;
       int j=0;
       int count=1;
       while (j<nums.length-1){
         if (nums[j]==nums[j+1]){
            j++;
         }
         else{
            i++;
            j++;
            nums[i]=nums[j];
            count++;
            
         }
       }
       return count;
    }
}