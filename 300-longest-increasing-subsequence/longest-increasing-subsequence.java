class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] list=new int[nums.length];
        int res=0;
        

        for(int i=0;i<list.length;i++){
            list[i]=1;
            res=Math.max(res,list[i]);
            //iterate on prev ones
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                list[i]=Math.max(list[i],1+list[j]);
                res=Math.max(res,list[i]);
                }
            }
        }
        return res;
    }
}