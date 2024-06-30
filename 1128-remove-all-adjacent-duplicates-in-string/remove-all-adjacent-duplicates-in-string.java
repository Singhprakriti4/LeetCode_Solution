class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk=new Stack<>();
        for(int i=s.length()-1;i>=0;i--){
            if(!stk.isEmpty() && stk.peek()==s.charAt(i)){
                stk.pop();
            }
            else{
                stk.push(s.charAt(i));
            }
        }
    StringBuilder ans=new StringBuilder();
     while(!stk.isEmpty()){
        ans.append(stk.peek());
        stk.pop();
     }
     return ans.toString();
    }
}