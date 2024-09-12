class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> h=new HashSet<>();
        for(int i=0;i<allowed.length();i++){
            h.add(allowed.charAt(i));
        }
        int ans=words.length;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                if(!h.contains(words[i].charAt(j))){
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
}