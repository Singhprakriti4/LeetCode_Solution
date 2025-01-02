class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int ans[]=new int[queries.length];
     int[] prefixcount=new int[words.length];

     String s=words[0];
     
      if(s.charAt(0)=='a' || s.charAt(0)=='e' || s.charAt(0)=='i' || 
           s.charAt(0)=='o' || s.charAt(0)=='u'){
            if(s.charAt(s.length()-1)=='a' || s.charAt(s.length()-1)=='e' || s.charAt(s.length()-1)==
            'i' || s.charAt(s.length()-1)=='o' || s.charAt(s.length()-1)=='u'){
                prefixcount[0]=1;
            }
        }
      

     for(int i=1;i<words.length;i++){
        s=words[i];
        if(s.charAt(0)=='a' || s.charAt(0)=='e' || s.charAt(0)=='i' || 
           s.charAt(0)=='o' || s.charAt(0)=='u'){
            if(s.charAt(s.length()-1)=='a' || s.charAt(s.length()-1)=='e' || s.charAt(s.length()-1)==
            'i' || s.charAt(s.length()-1)=='o' || s.charAt(s.length()-1)=='u'){
                prefixcount[i]=prefixcount[i-1]+1;
            }
            else{
              prefixcount[i]=prefixcount[i-1];  
            }
        }
        else{
             prefixcount[i]=prefixcount[i-1];
        }
     }

     for(int i=0;i<queries.length;i++){
        if(queries[i][0]==0){
            ans[i]=prefixcount[queries[i][1]];
        }
        else{
            ans[i]=prefixcount[queries[i][1]]-prefixcount[queries[i][0]-1];
        }
     }

     return ans;
    }
}