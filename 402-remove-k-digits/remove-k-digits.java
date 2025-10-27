class Solution {
    public String removeKdigits(String num, int k) {
        if(k>=num.length()){
            return "0";
        }

        Stack<Integer> stk=new Stack<>();

        for(int i=0;i<num.length();i++){
            while(!stk.isEmpty() && num.charAt(i)<num.charAt(stk.peek()) && k>0){
                k--;
                stk.pop();
            }
            stk.push(i);
        }
        while(k>0){
            stk.pop();
            k--;
        }

        StringBuilder str=new StringBuilder();
        while(!stk.isEmpty()){
            str.append(num.charAt(stk.pop()));
        }

        String ans=str.reverse().toString();
        ans=ans.replaceAll("^0+", "");
        if(ans.equals("")) return "0";
        return ans;

    }
    
}