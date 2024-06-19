class Solution {
    public boolean wordPattern(String pattern, String s) {
       String[] words=s.split(" ");
        if(pattern.length()!=(words.length)){
            return false;
        }
        HashMap<String,String> ans =new HashMap<>();
        HashMap<String,String> ans2=new HashMap<>();

        for(int i=0;i<words.length;i++){
           if(ans.containsKey(words[i])){
            if(!(pattern.charAt(i)+"").equals(ans.get(words[i]))){
               return false;
            }
           }
           else{
            ans.put(words[i],(pattern.charAt(i)+""));
           }
        }
        for(int i=0;i<pattern.length();i++){
            if(ans2.containsKey(pattern.charAt(i)+"")){
                if(!(words[i]).equals(ans2.get(pattern.charAt(i)+"" ))){
                    return false;
                }
            }
            else{
                ans2.put(pattern.charAt(i)+"",words[i]);
            }
        }
        return true;
    }
}