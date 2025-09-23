class Solution {
    public int removeDuplicates(int[] nums) {
      int curr=-200;
      int ptr=-1;

      for(int i=0;i<nums.length;i++){
        if(nums[i]!=curr){
            curr=nums[i];
            nums[++ptr]=curr;
        }
        else{
            continue;
        }
      } 

      return ptr+1; 
    }
}