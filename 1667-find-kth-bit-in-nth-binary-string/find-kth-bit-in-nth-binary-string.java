class Solution {
    public char findKthBit(int n, int k) {

        String answer=Test( n);
       
        return answer.charAt(k-1);
          
    }
    public String Test(int n){
        if(n==1){
            return "0";
        }
        String answer= Test(n-1)+"1"+rev_invert(Test(n-1));
        return answer;
    }
    public String rev_invert(String test){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<test.length();i++){
            if(test.charAt(i)=='0'){
                str.append("1");
            }
            else{
                str.append("0");
            }
        }
       
        return str.reverse().toString();
    }
}