class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
      int[] sum=new int[nums.length];
      sum[0]=nums[0] ;
      int count=0;

      for(int i=1;i<nums.length;i++){
        sum[i]=sum[i-1]+nums[i];
      }

      for(int i=0;i<nums.length;i++){
        for(int j=i;j<nums.length;j++){
            int currsum=sum[j];
            if(i>0) currsum-=sum[i-1];
            if(currsum>goal) break;
            if(currsum==goal){
                count+=1;
            }
        }
      }

      return count;
    }
}