class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       int range=0;
       for(int i=0;i<nums.length;i++){
        range+=nums[i];
       }
       if(Math.abs(target)>range || (target+range)%2==1) return 0;
       System.out.println(Math.abs(range-target)/2);
        return sum(nums,nums.length-1,Math.abs(range+target)/2);
    }
    public int sum(int[] nums,int ptr,int value){
        if(ptr==-1){
            if(value==0){
                return 1;
            }
            return 0;
        }
       if(nums[ptr]<=value){
        return sum(nums,ptr-1,value-nums[ptr])+sum(nums,ptr-1,value);
       }
       return sum(nums,ptr-1,value);
    }
}