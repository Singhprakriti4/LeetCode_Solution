class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length()==0 || s.length()==1){
            return s.length();
        }
    
        HashMap<Character, Integer> map=new HashMap<>();
        int len=1;

        int l=0;
        int e=0;
        // map.put(s.charAt(0),1);
        while(e<s.length() && l<s.length()){
           
                if(map.containsKey(s.charAt(e)) && map.get(s.charAt(e))>=l){
                    int target=map.get(s.charAt(e));
                    l=target+1;
                
                }
                else{
                    map.put(s.charAt(e),e);
                    len=Math.max(len,e-l+1);
                    e++;
                }
            }
            return len;
    }
}