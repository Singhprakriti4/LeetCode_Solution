class Solution {
    public int maxProduct(int[] nums) {
        // int[] product=new int[nums.length];
        // product[0]=nums[0];

        // for(int i=0; i<nums.length;i++){
        //     product[i]=product[i-1]*nums[i];
        // }
        int ans=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            int prod=nums[i];
            ans=Math.max(ans,prod);
            for(int j=i+1; j<nums.length;j++){
                prod*=nums[j];
                ans=Math.max(ans, prod);
            }
        }

        return ans;

    }
}