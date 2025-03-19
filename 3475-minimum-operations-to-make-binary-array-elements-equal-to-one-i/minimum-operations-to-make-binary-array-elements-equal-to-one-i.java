class Solution {
    public int minOperations(int[] nums) {
       //sliding window of size 3
       int i=0;
       int j=2;
       int ans=0;

       while(j<nums.length){
        if(nums[i]==0){
            //flip the bits
            flip(nums,i,j);
            ans++;
            i++;
            j++;
        }
        else{
            //move ahead.No need to flip
            i++;
            j++;
        }
       }   
       for(int k=i-1;k<nums.length;k++){
        if(nums[k]==0)
        return -1;
       }
       return ans;
    }
    void flip(int[] nums,int i, int j){
        for(int k=i;k<j+1;k++){
            if(nums[k]==0){
                nums[k]=1;
            }
            else{
                nums[k]=0;
            }
        }
    }
}