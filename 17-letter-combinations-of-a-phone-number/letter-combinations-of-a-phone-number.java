class Solution {
    List<String> result;
    public List<String> letterCombinations(String digits) {

        result=new ArrayList<>();
        HashMap<Integer, List<Character>> map=new HashMap<>();
        int gap=0;
        for(int i=2;i<=9;i++){
            map.put(i, new ArrayList<>());
            map.get(i).add((char)('a'+gap));
            gap+=1;
            map.get(i).add((char)('a'+gap));
            gap+=1;
            map.get(i).add((char)('a'+gap));
            gap+=1;
            if(i==7 || i==9){
                map.get(i).add((char)('a'+gap));
                gap+=1;
            }
        }

        combos(digits, 0, new StringBuilder(), map);
        return result;
    }
    public void combos(String str, int idx, StringBuilder sb,
    HashMap<Integer, List<Character>> map){
        if(idx==str.length()){
            result.add(sb.toString());
            return;
        }

        for(char c: map.get(str.charAt(idx)-'0')){
            sb.append(c);
            combos(str, idx+1, sb, map);
            sb.deleteCharAt(sb.length()-1);//backtrack
        }
    }
}