class Solution {
    public int lengthOfLIS(int[] nums) {
       int[] lis=new int[nums.length];
       lis[0]=1;
       for(int i=1;i<lis.length;i++){
        int max=0;
        for(int j=i-1;j>=0;j--){
            if(nums[j]<nums[i]){
                //a potential candidate
                max=Math.max(max,lis[j]);
            }
        }
        lis[i]=1+max;
       } 
       int maxlislength=0;

       for(int k: lis){
        //cuz it is not mandatory that the lis will end at the las index only
        maxlislength=Math.max(maxlislength, k);
       }
       return maxlislength;
    }
}