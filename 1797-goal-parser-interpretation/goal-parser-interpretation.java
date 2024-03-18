class Solution {
    public String interpret(String command) {
        StringBuilder answer=new StringBuilder();
        int len=command.length();
        for(int i=0;i<len-1;i++){
            if(command.charAt(i)=='G'){
                answer.append(command.charAt(i));
            }
            else if(command.charAt(i)=='('){
                if(command.charAt(i+1)==')'){
                    answer.append('o');
                }
                else{
                    answer.append("al");
                }
            }
        }
        if(command.charAt(len-1)=='G'){
            answer.append('G');
        }
        return answer.toString();
    }
}