class Solution {
    //get the first and the last occurance of each char
    public int countPalindromicSubsequence(String s) {
        int ans=0;

        HashMap<Character, List<Integer>> map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),new ArrayList<>());
            }
            map.get(s.charAt(i)).add(i);
        }

        for(Map.Entry<Character, List<Integer>> e: map.entrySet()){

            char ch=e.getKey();
            List<Integer> indices=e.getValue();

            int start=indices.get(0);
            int end=indices.get(indices.size()-1);

            Set<Character> set=new HashSet<>();
            for(int i=start+1;i<end;i++){
                char curr=s.charAt(i);
                if(!set.contains(curr)){
                    ans+=1;
                    set.add(curr);
                }
                else{
                    continue;
                }
            }

        }

        return ans;
    }
}