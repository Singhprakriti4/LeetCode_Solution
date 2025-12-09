class Solution {
    public int splitArray(int[] nums, int k) {
       int total=0;
       int max=Integer.MIN_VALUE;
       for(int n: nums){
        total+=n;
        max=Math.max(max,n);
       }
       int s=max;
       int e=total;
       int ans=0;

       while(s<=e){
        int m=s+(e-s)/2;
        if(valid(m,nums,k)){
            ans=m;
            e=m-1;
        }
        else{
            s=m+1;
        }
       }
       return ans;
    }
    public boolean valid(int size, int[] nums, int bags){
        int b=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>size){
                b+=1;
                sum=nums[i];
            }
        }
        b+=1;
        return b<=bags;
    }
}