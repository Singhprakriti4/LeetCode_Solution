class Solution {
    public int[] productExceptSelf(int[] nums) {

       int[] pre=new int[nums.length]; 
       int[] post=new int[nums.length]; 
       int[] ans=new int[nums.length];
       post[post.length-1]=nums[nums.length-1];

       for(int i=nums.length-2;i>=0;i--){
        post[i]=post[i+1]*nums[i];
       }

       for(int i=0;i<nums.length;i++){
        //remove current element from the post

        int postprod=1;
        if(i+1<nums.length){
            postprod=post[i+1];
        }
        int preprod=1;

        if(i-1>=0){
            preprod=pre[i-1];
        }
        ans[i]=postprod*preprod;
        pre[i]=preprod*nums[i];
       }
       return ans;
    }
}