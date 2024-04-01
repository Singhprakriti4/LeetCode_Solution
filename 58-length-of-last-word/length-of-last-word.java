class Solution {
    public int lengthOfLastWord(String s) {
        int count=0;
        int i=s.length()-1;
       while(i>=0) {
           if(s.charAt(i)==' '){
            if(count==0){
                i--;
            }
            else{
                return count;
            }
           }
           else{
             count++;
             i--;
           }
        }
        return count;
        
    }
}