class Solution {
    List<List<String>> ans=new ArrayList<>();

    public List<List<String>> partition(String s) {

        List<String> temp=new ArrayList<>();
         rec(s,0,0,temp);

        return ans;
        
    }
    public void rec(String s, int start, int i, List<String> temp){
        if(s.length()==0){
           ans.add(new ArrayList<>(temp));
           return; 
        }
        if(i==s.length()){
            //everything processed
            // ans.add(new ArrayList<>(temp));
            return;
        }

        //if palindrome found
        if(isPalindrome(s,start,i)){
            temp.add(s.substring(start,i+1));
            rec(s.substring(i+1,s.length()),0,0,temp);
            temp.remove(temp.size()-1);
        }

        //move forward in the same string
        rec(s,start,i+1,temp);
    }

    public boolean isPalindrome(String s, int b, int e){
       String s1=s.substring(b,e+1);
       String s2 = new StringBuilder(s.substring(b, e + 1)).reverse().toString();
       
        if(s1.equals(s2)){
            return true;
        }
        return false;
    }
}