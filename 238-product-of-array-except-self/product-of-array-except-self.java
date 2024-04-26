class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre=new int[nums.length];
        int[] post=new int[nums.length];
        int[] ans=new int[nums.length];

        int start=0;
        int end=nums.length-1;
        int pre_p=1;
        int post_p=1;
        while(start<nums.length && end>=0){
          if(start==0 && end==nums.length-1){
            pre[start]=1;
            post[end]=1;
           
          }
          else{
            pre_p=pre_p*(nums[start-1]);
            pre[start]=pre_p;
            post_p=post_p*(nums[end+1]);
            post[end]=post_p;
          }
          start++;
          end--;
        }
        for(int i=0;i< nums.length;i++){
          ans[i]=pre[i]*post[i];
        }
        return ans;
    }
}