class Solution {
    int maxscore=Integer.MIN_VALUE;
    public int maxScore(String s) {
        score(s,1,s.substring(0,1),s.substring(1,s.length()));
      return maxscore;
    }
    public void score(String s,int i, String left,String right){
        if(left.equals("") || right.equals("")){
            return;
        }
        //calculating the score
        int leftscore=numinstr(left,'0');
        int rightscore=numinstr(right,'1');
        int total=leftscore+rightscore;

        maxscore=total>maxscore?total:maxscore;

        score(s,i+1,s.substring(0,i),s.substring(i,s.length()));
    }

    //calculating number of 0 or 1
    public int numinstr(String s, char c){
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c){
                ans++;
            }
        }
        return ans;
    }
}