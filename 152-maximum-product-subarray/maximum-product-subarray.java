class Solution {
    public int maxProduct(int[] nums) {

       int[] prodsum=new int[nums.length];
       prodsum[0]=nums[0];

       for(int i=1;i<nums.length;i++){
        if(nums[i]==0 || nums[i-1]==0){
            prodsum[i]=nums[i];
        }
        else{
            prodsum[i]=nums[i]*prodsum[i-1];
        }
       } 

       int ans=Integer.MIN_VALUE;

       int left=0;
       int leftneg=-1;
       int rightneg=-1;
       int right=0;

       while(right<nums.length+1){
        if(right<nums.length && nums[right]==0) ans=Math.max(ans,0);
        if(right==nums.length || nums[right]==0 ){
            // System.out.println(left+" "+right);

            int curr=calculate(left,right-1,prodsum,nums);
            // System.out.println(curr);
            curr=Math.max(curr, calculate(leftneg+1,right-1,prodsum,nums));
            // System.out.println(curr);
            curr=Math.max(curr, calculate(left,rightneg-1,prodsum,nums));
            ans=Math.max(ans, curr);
            // System.out.println(ans+" "+curr);
            //reset kar do
            leftneg=-1;
            rightneg=-1;
            left=right+1;
        }
        else{
            if(nums[right]<0){
                if(leftneg==-1){
                    leftneg=right;
                    rightneg=right;
                }
                else{
                    rightneg=right;
                }
            }
        }
        right++;
       }
        
        int curr2=calculate(left,right-1,prodsum,nums);
        curr2=Math.max(curr2, calculate(leftneg+1,right-1,prodsum,nums));
        curr2=Math.max(curr2, calculate(left,rightneg-1,prodsum,nums));
        ans=Math.max(ans, curr2);
        // System.out.println(ans+" "+curr2);
       //last block must still be not processed
       return ans;
    }
    public int calculate(int left, int right, int[] prodsum,int[] nums){
        if(left>right || left<0 || right<0 || right>=prodsum.length){
            return Integer.MIN_VALUE;
        }
        int ans=prodsum[right];
        if(left-1>=0){
            if(nums[left-1]!=0){
               ans/=prodsum[left-1];
            }
        }

        // ans=Math.max()
        return ans;
    }
}