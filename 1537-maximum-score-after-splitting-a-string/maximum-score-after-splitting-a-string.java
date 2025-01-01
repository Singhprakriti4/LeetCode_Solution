class Solution {
    public int maxScore(String s) {
        int maxscore=0;
        int ones=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                ones++;
            }
        }
        int zeros=0;
        int currscore=0;
        for(int i=0;i<s.length()-1;i++){

           if(s.charAt(i)=='0'){
            zeros++;
           }
           else{
            ones--;
           }
           currscore=ones+zeros;
            maxscore=Math.max(currscore,maxscore);
        }

        return maxscore;

    }
}