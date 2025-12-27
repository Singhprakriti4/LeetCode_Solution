class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int maxlen=0;

        while(j<s.length()){
            char ch=s.charAt(j);
            if(!map.containsKey(ch) || map.get(ch)<i){
                //valid
                map.put(ch,j);//current index
                maxlen=Math.max(maxlen, j-i+1);
                j++;
            }
            else{
                // shift i to duplcate elemnt ka index +1
                i=map.get(ch)+1;
            }
        }
        return maxlen;
    }
}