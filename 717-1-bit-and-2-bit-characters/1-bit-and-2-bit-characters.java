class Solution {
    public boolean isOneBitCharacter(int[] nums) {
       
       if(nums.length==1) return true;
       if(nums.length==2) return nums[0]!=1;

    int idx=0;
    while(idx<nums.length){
        if(nums[idx]==1){
            idx+=2;
        }
        else{
            if(idx==nums.length-1) return true;
            idx+=1;
        }
    }
    return false;
    }
}