class Solution {
    public boolean isPalindrome(int x) {
        if(x==0){
            return true;
        }
        if(x<0){
            return false;
        }
       String a=Integer.toString(x);
       String b=new StringBuilder(a).reverse().toString();
       if(a.equals(b)){
        return true;
       }
       return false;
    }
}