class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
     int ans[]=new int[queries.length];
     int[] prefixcount=new int[words.length];

     String s=words[0];
     
       if(isVowel(s.charAt(0)) && isVowel(s.charAt(s.length()-1))){
                prefixcount[0]=1;
        
        }
        
     for(int i=1;i<words.length;i++){
        s=words[i];
        if(isVowel(s.charAt(0)) && isVowel(s.charAt(s.length()-1))){
                prefixcount[i]=prefixcount[i-1]+1;
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
    boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
}