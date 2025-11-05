class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        //make two dps : with taking one and without taking one and choose the most one

        int[] dptrue=new int[nums.length];//go only till length-2
        int[] dpfalse=new int[nums.length];// start with the second index and go till last

        dptrue[0]=nums[0];//took the first element
        dptrue[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length-1;i++){
            dptrue[i]=Math.max(dptrue[i-2]+nums[i], dptrue[i-1]);
        }

        int ans1=dptrue[nums.length-2];

        dpfalse[0]=0;//not considering the first one
        dpfalse[1]=nums[1];
        for(int i=2;i<nums.length;i++){
            dpfalse[i]=Math.max(dpfalse[i-2]+nums[i], dpfalse[i-1]);
        }

        int ans2=dpfalse[nums.length-1];

        return Math.max(ans1,ans2);
    }
}