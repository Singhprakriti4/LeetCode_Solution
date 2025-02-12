class Solution {
    public String getHappyString(int n, int k) {
       if(k>3*Math.pow(2,n-1)){
        return "";
       }
       ArrayList<String> ans=new ArrayList<>();
       ArrayList<Character> list=new ArrayList<>();
   
    happy(n,list,'d',ans);
    // Collections.sort(ans);
    return ans.get(k-1);
    }
    public void happy(int n,ArrayList<Character> list,char parent, ArrayList<String> ans){
        //base case
        if(list.size()==n){
            //convert in string and store in ans
            String s=convert(list);
            ans.add(s);
            return;
        }
        //loop of all possibility
        if('a'!=parent){
            list.add('a');
            happy(n,list,'a',ans);
            list.remove(list.size()-1);
        }
        if('b'!=parent){
            list.add('b');
            happy(n,list,'b',ans);
            list.remove(list.size()-1);
        }
        if('c'!=parent){
            list.add('c');
            happy(n,list,'c',ans);
            list.remove(list.size()-1);
        }

    }
    public String convert(ArrayList<Character> list){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<list.size();i++){
            str.append(list.get(i));
        }
        return str.toString();
    }
}