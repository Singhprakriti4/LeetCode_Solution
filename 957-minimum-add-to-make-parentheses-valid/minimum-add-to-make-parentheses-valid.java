class Solution {
    public int minAddToMakeValid(String s) {
        if(s=="")return 0;
        int ans=0;
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!stk.isEmpty() && s.charAt(i)==')' && stk.peek()=='('){
                stk.pop();
            }
            else{
                stk.push(s.charAt(i));
            }
        }
        while(!stk.isEmpty()){
            ans++;
            stk.pop();
        }
        return ans;
    }
}