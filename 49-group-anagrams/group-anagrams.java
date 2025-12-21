class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> outer=new ArrayList<>();

        for(int i=0;i<strs.length;i++){
            String s=strs[i];
            if(s.equals("-1")){
                continue;
            }
            else{
                int[] num=new int[26];
                for(int j=0;j<s.length();j++){
                    num[(s.charAt(j)-'a')]+=1;
                }
                List<String> inner=new ArrayList<>();
                inner.add(s);
                for(int j=i+1;j<strs.length;j++){
                    if(strs[j].equals("-1")) continue;
                    if(match(s,strs[j],num)){
                        inner.add(strs[j]);
                        strs[j]="-1";
                    }
                }
                outer.add(inner);
            }
        }
        return outer;
    }
    public boolean match(String s, String t, int[] nums){
        if(s.length()!=t.length()){
            return false;
        }
        int[] num=nums.clone();
        for(int i=0;i<t.length();i++){
            if(num[(t.charAt(i)-'a')]<=0){
                return false;
            }
            else{
                num[(t.charAt(i)-'a')]-=1;
            }
        }
        return true;
    }
}