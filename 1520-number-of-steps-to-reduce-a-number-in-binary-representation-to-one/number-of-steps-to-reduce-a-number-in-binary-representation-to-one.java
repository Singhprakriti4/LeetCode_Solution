class Solution {
    public int numSteps(String s) {
        StringBuilder sb=new StringBuilder(s);
        int count=0;

        while(sb.length()!=1){
            if(sb.charAt(sb.length()-1)=='0'){
                //even
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                //odd

                //1: find first zero from the end
                int i=sb.length()-1;
                while(i>=0 && sb.charAt(i)!='0' ){

                    sb.setCharAt(i, '0');
                    i--;
                }
                
                if(i==-1){
                    sb.append('0');
                    sb.setCharAt(0, '1');
                }
                else{
                    sb.setCharAt(i, '1');
                }

            }
            count++;
        }
        return count;
    }
}