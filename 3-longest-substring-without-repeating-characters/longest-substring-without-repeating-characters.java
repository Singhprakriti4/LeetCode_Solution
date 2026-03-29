class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map=new HashMap<>();
        int start=0;
        int end=0;
        int currlen=0;
        int maxlen=0;

        while(end<s.length() && start<s.length()){
            
            char curr=s.charAt(end);
            if(!map.containsKey(curr)){
                map.put(curr, end);
                currlen+=1;
                end+=1;
                maxlen=Math.max(maxlen, currlen);
            }
            else{
                int to=map.get(curr);
                System.out.println(to+" "+end);
                while(start<=to){
                    map.remove(s.charAt(start));
                    start++;
                    currlen-=1;
                }
                // end=start;
                // currlen=0;
            }
        }

        return maxlen;
    }
}