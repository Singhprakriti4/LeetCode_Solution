class Solution {
    public String defangIPaddr(String address) {
       StringBuilder result=new StringBuilder();
       int length=address.length();
       for(int i=0;i<length;i++){
        if(address.charAt(i)=='.'){
             result.append("[.]");
           
        }
        else{
            result.append(address.charAt(i));
        }
       }
       System.out.println(result);
       return result.toString();
    }
}