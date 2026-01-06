class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans=new ArrayList<>();
        pair(n,n,new StringBuilder());
        return ans;

    }
    public void pair(int open, int close, StringBuilder str){
    if(open>close || close<0 || open<0){
            return;
    }
    // System.out.println(open+" "+close);
    if(open==0 && close==0){
            //convert in string and add in list
            System.out.println("hi");
            String s=str.toString();
            ans.add(s);
            return;
    }

        if(open==0){
            //we can add only closing brakett
            str.append(')');
            pair(open, close-1, str);
            str.deleteCharAt(str.length() - 1);
        }
        else if(open==close){
            //we can add only open
            str.append('(');
            pair(open-1, close, str);
            str.deleteCharAt(str.length()-1);
        }
        else if(open<close){
            //we can add open or close both
            str.append(')');
            pair(open, close-1, str);
            str.deleteCharAt(str.length() - 1);
            str.append('(');
            pair(open-1, close, str);
            str.deleteCharAt(str.length()-1);
        }
    }
}