class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder one=new StringBuilder();
        StringBuilder two=new StringBuilder();
        for(int i=0;i<word1.length;i++){
            one.append(word1[i]);
        }
         for(int i=0;i<word2.length;i++){
            two.append(word2[i]);
        }
        if(one.toString().equals(two.toString())){
            return true;
        }
       
        return false;
    }
}