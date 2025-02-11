class Solution {
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> partition(String s) {
        ArrayList<String> list=new ArrayList<>();
        part(s,list);
        return ans;
    }
    public void part(String s,ArrayList<String> list){
        if(s.length()==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=1;i<=s.length();i++){
            if(isPalindrome(s.substring(0,i))){
            list.add(s.substring(0,i));
            part(s.substring(i,s.length()),list);
            list.remove(list.size()-1);
            }
        }

    }
    public boolean isPalindrome(String s){
        if(s.equals(new StringBuilder(s).reverse().toString())){
            return true;
        }
        return false;
    }
}