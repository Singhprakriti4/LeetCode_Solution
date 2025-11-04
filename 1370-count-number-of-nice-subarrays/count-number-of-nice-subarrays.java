class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans=0;
        int currcount=0;
        int oddnums=0;
        int left=0;

        for(int right=0;right<nums.length;right++){
            if(nums[right]%2==1){
                oddnums+=1;
            }
            if(oddnums<k){
                //move forward
                continue;
            }
            else if(oddnums==k){

                while(nums[left]%2==0){
                    currcount+=1;
                    left++;
                }

                ans+=currcount+1;

            }
            else{
                currcount=0;
               while(oddnums>k){
                if(nums[left]%2==1){
                    oddnums-=1;
                }
                left++;
               }
               //now it is equal so run this for that

              while(nums[left]%2==0){
                    currcount+=1;
                    left++;
                }

                ans+=currcount+1;
            }
        }
        return ans;
    }
}