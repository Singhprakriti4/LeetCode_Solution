class Solution {
    public boolean canConstruct(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        if(s.length()<k){
            return false;
        }
        else if(oddcount(map,s)>k){
            return false;
        }
       return true;
    }
    int oddcount(HashMap<Character,Integer> map,String s){
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
            else{
                map.put(s.charAt(i),1);
            }
        }
        for(Integer values: map.values()){
            if(values%2!=0){
                ans++;
            }
        }
        return ans;
    }
}