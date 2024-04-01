class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder answer=new StringBuilder();
        int i=0;int j=0;
        while(i<word1.length() && j<word2.length()){
            answer.append(word1.charAt(i));
            answer.append(word2.charAt(j));
            i++;
            j++;
        }
        while(i<word1.length()){
             answer.append(word1.charAt(i));
             i++;
        }
        while(j<word2.length()){
              answer.append(word2.charAt(j));
              j++;
        }
        return answer.toString();
    }
}