class Solution {

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {

        List<String> ans=new ArrayList<>();
        int n=words.length;

        List<String>[][] dp=new ArrayList[n][n+1];
        ans=subsequence(words,groups,0,-1,dp);
        return ans;
    }
    public List<String> subsequence(String[] words, int[] groups,int idx,int previdx,List<String>[][] dp){
        //base case
        if(idx==words.length){
           return new ArrayList<>();
        }
         
         if(dp[idx][previdx+1]!=null) return dp[idx][previdx+1];

         String prev="";
         int prevgrp=groups[idx];

         if(previdx!=-1){
            prev=words[previdx];
            prevgrp=groups[previdx];
         }
         
         List<String> res1=new ArrayList<>();
         List<String> res2;

         if( prev=="" || (words[idx].length()==prev.length() && hd(words[idx],prev)==1
         && prevgrp!=groups[idx])){
           
            res1.add(words[idx]);
            res1.addAll(subsequence(words,groups,idx+1,idx,dp));
            
            
        }
            res2=subsequence(words,groups,idx+1,previdx,dp);

            List<String> result=(res1.size() > res2.size())? res1: res2;
            dp[idx][previdx+1]=new ArrayList<>(result);
            return dp[idx][previdx+1];
    }

        public int hd(String a, String b){
            int res=0;
            for(int i=0;i<a.length();i++){
                if(a.charAt(i)!=b.charAt(i)) res+=1;
            }
            return res;
        }
}