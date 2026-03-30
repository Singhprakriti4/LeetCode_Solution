class Solution {
    public int longestOnes(int[] nums, int k) {
       int test=0;
       int currlen=0;
       int maxlen=0;
       int start=0;
       int end=0;
       while(end<nums.length && start<=nums.length){
        if(nums[end]==1){
            currlen+=1;
            maxlen=Math.max(maxlen, currlen);
            end++;
        }
        else if(test<k){
            test++;
            currlen+=1;
            maxlen=Math.max(currlen, maxlen);
            end++;
        }
        else{
            if(nums[start]==0){
                start++;
                test--;
                currlen-=1;
            }
            else{
                start++;
                currlen-=1;
            }
        }
       }
       return maxlen; 
    }
}