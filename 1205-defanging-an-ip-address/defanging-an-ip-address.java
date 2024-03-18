class Solution {
    public String defangIPaddr(String address) {

         address = address.replace(".","[.]");
        return address;
      
    //    int length=address.length();
    //     StringBuilder result=new StringBuilder();
    //    for(int i=0;i<length;i++){
    //     if(address.charAt(i)=='.'){
    //          result.append("[.]");
            
           
    //     }
    //     else{
    //         result.append(address.charAt(i));
    //     }
    //    }
      
    //    return result.toString();
    }
}