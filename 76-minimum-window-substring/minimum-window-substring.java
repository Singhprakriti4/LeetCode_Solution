class Solution {
    public String minWindow(String s, String t) {
       if(t.length()>s.length()) {
        return "";
       }
       int len=Integer.MAX_VALUE;
       String ans="";

       HashMap<Character, Integer> level=new HashMap<>();
       Set<Character> set=new HashSet<>();

       for(int i=0;i<t.length();i++){
        level.put(t.charAt(i), level.getOrDefault(t.charAt(i), 0)+1);
        set.add(t.charAt(i));
       }

       int left=0;
       HashMap<Character, Integer> currfreq=new HashMap<>();
       for(int right=0;right<s.length();right++){

        char c=s.charAt(right);
        if(set.contains(c)){
            currfreq.put(c,currfreq.getOrDefault(c,0)+1);

                while(check(level, currfreq, set)){

                    if(right-left+1<len){
                    ans=s.substring(left,right+1);
                    len=right-left+1;
                    }
                    //we will try to find the shortest length
                    if(currfreq.containsKey(s.charAt(left))){
                        currfreq.put(s.charAt(left),currfreq.get(s.charAt(left))-1);
                        if(currfreq.get(s.charAt(left))==0){
                            currfreq.remove(s.charAt(left));
                        }
                    }
                    left++;
                }
            
        }
       }
       return ans;
    }
    public boolean check(HashMap<Character, Integer> level,
    HashMap<Character, Integer> currfreq, Set<Character> set){

        if(currfreq.size()<set.size()) return false;

        for(Map.Entry<Character, Integer> e: level.entrySet()){
            if(currfreq.get(e.getKey())<e.getValue()) return false;
        }
        return true;
    }
}