class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int diff[]=new int[nums.length];
        int start=-1;
        int end=queries.length-1;
        int ans=-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(iszero(mid,queries,nums)){
                ans=mid+1;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
    public boolean iszero(int m,int[][] queries,int[] nums){
       
   
      int diff[]=new int[nums.length];
      if(m!=-1){
      for(int i=0;i<m+1;i++){
        int s=queries[i][0];
        int e=queries[i][1];
        int add=queries[i][2];

        diff[s]+=add;
        if(e+1<nums.length)
        diff[e+1]-=add;


      } 
      }
      //calculate prefix sum
      if(diff[0]<nums[0]) return false;
      for(int i=1;i<diff.length;i++){
        diff[i]=diff[i]+diff[i-1];
        if(diff[i]<nums[i]){
            return false;
        }
      }
      return true;
    }
}