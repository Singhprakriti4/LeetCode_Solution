class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int prev=-1;
        int curr=0;
        while(curr<nums.length){
            if(nums[curr]==0){
                curr++;
            }
            else if(prev==-1){
                prev=curr;
                curr++;
            }
            else if(curr-prev-1<k){
                return false;
            }
            else{
                prev=curr;
                curr++;
            }
        }

        return true;
    }
}