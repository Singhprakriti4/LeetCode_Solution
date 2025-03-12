class Solution {
    public int maximumCount(int[] nums) {
       int neg=0;
       int zero=0;
       for(int i=0;i<nums.length;i++){
        if(nums[i]<0){
            neg++;
        }
        if(nums[i]==0){
            zero++;
        }
       }

       int pos=nums.length-neg-zero;
       if(neg>pos){
        return neg;
       }
       return pos;
    }
}