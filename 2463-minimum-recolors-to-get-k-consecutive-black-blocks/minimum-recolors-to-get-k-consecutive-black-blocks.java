class Solution {
    public int minimumRecolors(String blocks, int k) {
       int ans=Integer.MAX_VALUE;
       int i=0;
       int j=-1; 
       int expected=0;
       while(j<k-1){
        j++;
        if(blocks.charAt(j)=='W'){
            expected+=1;
        }
       }
       ans=expected;

       while(j<blocks.length()-1){
        if(blocks.charAt(i)=='W'){
            expected--;
        }
        i++;
        j++;
        if(blocks.charAt(j)=='W'){
            expected++;
        }
        if(expected<ans){
            ans=expected;
        }
       }
      return ans;
    }
}