class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> outer=new ArrayList<>();
         HashMap<List<Character>, List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            // if(strs[i].equals("-1")) continue;
            List<Character> l=new ArrayList<>();

            for(int j=0;j<strs[i].length();j++){
                l.add(strs[i].charAt(j));//add krdo isko bhi
        }
            Collections.sort(l);

            if(map.containsKey(l)){
                map.get(l).add(strs[i]);
            }
            else{
                map.put(l, new ArrayList<>());
                map.get(l).add(strs[i]);
            }

        }
        for(Map.Entry<List<Character>, List<String>> e: map.entrySet()){
            outer.add(e.getValue());
        }
        return outer;
    }
}