class Solution {
    public String getHappyString(int n, int k) {
       if(k>3*Math.pow(2,n-1)){
        return "";
       }
       ArrayList<String> ans=new ArrayList<>();
      StringBuilder list=new StringBuilder();
   
    happy(n,list,'d',ans);
    return ans.get(k-1);
    }
    public void happy(int n,StringBuilder list,char parent, ArrayList<String> ans){
        //base case
        if(list.length()==n){
            //convert in string and store in ans
            ans.add(list.toString());
            return;
        }
        //loop of all possibility
        if('a'!=parent){
            list.append('a');
            happy(n,list,'a',ans);
            list.deleteCharAt(list.length()-1);
        }
        if('b'!=parent){
            list.append('b');
            happy(n,list,'b',ans);
            list.deleteCharAt(list.length()-1);
        }
        if('c'!=parent){
            list.append('c');
            happy(n,list,'c',ans);
            list.deleteCharAt(list.length()-1);
        }

    }
    
}