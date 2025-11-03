class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
    
      int count=0;

      for(int i=0;i<nums.length;i++){
        int currsum=0;
        for(int j=i;j<nums.length;j++){
            currsum+=nums[j];
            if(currsum>goal) break;
            if(currsum==goal){
                count+=1;
            }
        }
      }

      return count;
    }
}