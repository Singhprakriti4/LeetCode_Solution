class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
       //greedy
       List<String> ans=new ArrayList<>();

       if(words.length==0) return ans;

       int curr=groups[0] ;
       ans.add(words[0]);
       for(int i=1;i<words.length;i++){
        int bit=groups[i];
        if(groups[i]!=curr){
            curr=groups[i];
            ans.add(words[i]);
        }
       }

       return ans;
    }
}