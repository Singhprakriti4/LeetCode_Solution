class Solution {
    public int longestNiceSubarray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        //bitmasking technique
        int ans=1;

        for(int i=0;i<nums.length-1;i++){

            int currlen=1;
            int tillnow=nums[i];
            
            for(int j=i+1;j<nums.length;j++){
             if((nums[j] & tillnow)==0){

                //j has to be included in subarray starting from i
                tillnow=tillnow | nums[j];
                currlen++;
             }
             else{
                //j cannot be included in the subarray starting from i
                if(currlen>ans){
                    ans=currlen;
                }
                break;
             }
              if(currlen>ans){
                    ans=currlen;
                }
            }
        }
        return ans;
    }
}