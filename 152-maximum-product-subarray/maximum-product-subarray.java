class Solution {
    public int maxProduct(int[] nums) {
        int ans=Integer.MIN_VALUE;
        int negidx=-1;
        int prod=1;
        int[] grid=new int[nums.length];
        grid[0]=nums[0];

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                grid[i]=1;
            }
            else if(i==0){
                grid[0]=nums[0];
            }
            else{
                grid[i]=grid[i-1]*nums[i];
            }
            
            ans=Math.max(ans,nums[i]);

            if(nums[i]!=0){
                prod*=nums[i];
                ans=Math.max(ans,prod);
                if(nums[i]<0 && negidx==-1){
                    negidx=i;
                }
            }
            else{
                //see by excluding till negidx
                if(negidx!=i-1 && negidx!=-1){
                    //see by removing the first occurance of the negative elemnt
                    //this will handle the odd no of neg elements wala problem
                ans=Math.max(ans, grid[i-1]/grid[negidx]);
                }
                negidx=-1;
                prod=1;
            }
        }

        //if in case 0 never appeared then i will ahve to take that into account
        if(negidx!=-1 && negidx!=nums.length-1){
            ans=Math.max(ans, grid[nums.length-1]/grid[negidx]);
        }
        return ans;
    }
}