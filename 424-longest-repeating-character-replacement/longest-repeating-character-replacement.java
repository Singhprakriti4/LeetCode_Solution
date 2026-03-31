class Solution {
    public int characterReplacement(String str, int k) {

        Map<Character, Integer> map=new HashMap<>();
        int s=0;
        int e=0;
        int len=0;
        int maxlen=0;

        while(s<str.length() && e<str.length()){
            char curr=str.charAt(e);
            map.put(curr, map.getOrDefault(curr,0)+1);
            boolean feasible=false;
            for(Map.Entry<Character, Integer> entry: map.entrySet()){
                if(entry.getValue()+k>=e-s+1){
                    feasible=true;
                    break;
                }
            }
            if(feasible){
                e++;
                len++;
                maxlen=Math.max(maxlen, len);
            }
            else{
                map.put(curr, map.get(curr)-1);
                map.put(str.charAt(s), map.get(str.charAt(s))-1);
                len--;
                s++;
            }
        }
        return maxlen;
    }
}