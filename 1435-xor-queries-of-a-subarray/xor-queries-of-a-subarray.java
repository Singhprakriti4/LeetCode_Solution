class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
     int[] ans=new int[queries.length];
     int k=-1;
      for(int i=0;i<queries.length;i++){ 
        int start=queries[i][0];
        int end=queries[i][1];
        int value=arr[start];
        while(start+1<=end){
            value=value^arr[start+1];
            start++;
        }
        k++;
        ans[k]=value;
      }
      return ans;
    }
}