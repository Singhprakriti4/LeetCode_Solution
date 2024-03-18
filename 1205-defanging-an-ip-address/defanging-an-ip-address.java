class Solution {
    public String defangIPaddr(String address) {
    //      int n = address.length();
    //    StringBuilder sb = new StringBuilder();
    //    for(int i=0;i<n;i++){
    //        if(address.charAt(i)=='.'){
    //            sb.append("[");
    //            sb.append(".");
    //            sb.append("]");
    //        }
    //        else{
    //            sb.append(address.charAt(i));
    //        }
    //    } 
    //    String str = sb.toString();
    //    return str;
       StringBuilder result=new StringBuilder();
       int length=address.length();
       for(int i=0;i<length;i++){
        if(address.charAt(i)=='.'){
             result.append("[");
              result.append(".");
               result.append("]");
           
        }
        else{
            result.append(address.charAt(i));
        }
       }
       System.out.println(result);
       return result.toString();
    }
}