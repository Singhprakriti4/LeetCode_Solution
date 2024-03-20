class Solution {
    public boolean halvesAreAlike(String s) {
       s=s.toLowerCase(); 
       int counta=0,countb=0;
       for(int i=0;i<s.length()/2;i++){
        if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i'
        || s.charAt(i)=='o' || s.charAt(i)=='u'){
            counta++;
        }
       }
       for(int j=s.length()/2;j<s.length();j++){
        if(s.charAt(j)=='a' || s.charAt(j)=='e' || s.charAt(j)=='i' ||
        s.charAt(j)=='o' || s.charAt(j)=='u'){
            countb++;
        }
       }
       if(counta==countb){
        return true;
       }
       return false;
    }
}