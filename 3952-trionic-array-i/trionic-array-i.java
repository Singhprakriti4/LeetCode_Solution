class Solution {
    public boolean isTrionic(int[] nums) {
        int val=1;//odd: increasing , even : decreasing
        if(nums.length<4){
            return false;
        }
        if(nums[1]<=nums[0]) return false;
        for(int i=1;i<nums.length;i++){
            if(val>3 || nums[i]==nums[i-1]){
                return false;
            }
            else{
                if(val%2==1){
                    //strictly increasing
                    if(nums[i]<=nums[i-1]){
                        //turn change
                        val+=1;
                    }
                }
                else{
                    //strictly decreasing
                    if(nums[i]>=nums[i-1]){
                        val+=1;
                    }
                }
            }
        }
        if(nums[nums.length-1]<=nums[nums.length-2]) return false;
        if(val<3){
            return false;
        }
        return true;
    }
}