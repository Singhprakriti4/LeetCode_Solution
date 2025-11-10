class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stk=new Stack<>();
        // char opr='-1';

        for(int i=0;i<expression.length();i++){
            char ch=expression.charAt(i);
            if(ch=='(' || ch=='&' || ch=='|' || ch=='!' ||
            ch==',' || ch=='t' || ch=='f'){
                stk.push(ch);
            }
            else{
                //we found a closing bracett
                //1: pop till the first operand and make string
                StringBuilder sb=new StringBuilder();
                while(stk.peek()!='('){
                    sb.append(stk.pop());
                }
                stk.pop();//removing the opening bracett
                char o=stk.pop();//removing the operator
                if(o=='&'){
                    stk.push(and_opr(sb.toString()));
                }
                if(o=='|'){
                    stk.push(or_opr(sb.toString()));
                }
                if(o=='!'){
                    stk.push(not_opr(sb.toString()));
                }
            }
        }
        char res= stk.peek();
        if(res=='f'){
            return false;
        }
        return true;
    }
    
    public char and_opr(String str){

      char  ans='t';

      for(int i=str.length()-1;i>=0;i--){
        if(str.charAt(i)=='f'){
            ans='f';
            return ans;
        }
      }
      return ans;
    }
    public char or_opr( String str){
        char  ans='f';

      for(int i=str.length()-1;i>=0;i--){
        if(str.charAt(i)=='t'){
            ans='t';
            return ans;
        }
      }
      return ans;
    }
    public char not_opr(String str){
        char ans='t';
        for(int i=str.length()-1;i>=0;i--){
        if(str.charAt(i)=='t'){
            ans='f';
            return ans;
        }
        if(str.charAt(i)=='f'){
            ans='t';
            return ans;
        }
      }
      return ans;
    }
}