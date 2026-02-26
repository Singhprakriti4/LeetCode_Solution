class Solution {
    public int numSteps(String s) {
        StringBuilder sb=new StringBuilder(s);
        int count=1;;

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
                    i--;
                }
                
                if(i!=-1 ){
                    for(int j=i;j<sb.length();j++){
                        if(j==i){
                            sb.setCharAt(j, '1');
                        }
                        else{
                            sb.setCharAt(j, '0');
                        }
                    }
                }
                else{
                    //new bit will be added
                    for(int j=0;j<sb.length();j++){
                        if(j==0){
                            sb.setCharAt(j, '1');
                        }
                        else{
                            sb.setCharAt(j, '0');
                        }
                    }
                    sb.append('0');
                }

            }
            count++;
        }
        return count-1;
    }
}