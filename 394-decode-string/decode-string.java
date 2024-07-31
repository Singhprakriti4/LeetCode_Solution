class Solution {
    public String decodeString(String s) {
     
     Stack<Character> stk=new Stack<>();
     StringBuilder ans= new StringBuilder();

      for(int i=0;i<s.length();i++){
        if(s.charAt(i)==']'){
           StringBuilder in_bracett=new StringBuilder();
           while(stk.peek()!='['){
            in_bracett.append(stk.pop());
           }
           stk.pop();
           
           StringBuilder  num= new StringBuilder();
          
           while( !stk.isEmpty() && stk.peek()-'0'>=0 && stk.peek()<='9'){
              num.append(stk.pop());
           }
            int times=Integer.parseInt(num.reverse().toString());
          
           String tobeadded= repeatString(in_bracett.toString(),times);
           
           for(int k=tobeadded.length()-1;k>=0;k--){
            stk.push(tobeadded.charAt(k));
           }
        }
        else{
           stk.push(s.charAt(i));
        }
      }
      
      while(!stk.isEmpty()){
        ans.append(stk.pop());
      }
      
      return ans.reverse().toString();
    }
    public static String repeatString(String str, int repetitions) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repetitions; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}