class Solution {
    public String restoreString(String s, int[] indices) {
        StringBuilder ans=new StringBuilder();
         int k=0;
       while(ans.length()!=indices.length){
       
          for(int i=0;i<indices.length;i++)
          {
              if(indices[i]==k){
                ans.append(s.charAt(i));
                k++;
                break;
              }
          }
       }
       return ans.toString();
    }
}