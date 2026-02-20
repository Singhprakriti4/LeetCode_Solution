class Solution {
    public String makeLargestSpecial(String s) {
        if(s.length()<=2){
            return s;
        }
        List<String> list=new ArrayList<>();
        int val=0;
        int idx=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                val+=1;
            }
            else{
                val-=1;
            }
            if(val==0){
                String inner = makeLargestSpecial(s.substring(idx+1, i));
                               list.add("1" + inner + "0");
                idx=i+1;
            }
        }

        Collections.sort(list);
        String ans="";
        for(int i=list.size()-1;i>=0;i--){
            ans+=list.get(i);
        }
        return ans;
    }
}