class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] answer=new int[queries.length]; 
        int index=0;
      int[] prexor=new int[arr.length]  ;
      prexor[0]=arr[0];
      for(int i=1;i<arr.length;i++){
        prexor[i]=prexor[i-1]^arr[i];
      }
      for(int j=0;j<queries.length;j++){
        int left=queries[j][0];
        int right=queries[j][1];
        if(left==0){
            answer[index]= prexor[right];
        }
        else{
            answer[index]=prexor[right]^prexor[left-1];
        }
        index++;
      }
      return answer;
    }
}