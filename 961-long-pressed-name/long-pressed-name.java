class Solution {
    public boolean isLongPressedName(String name, String typed) {
       int i=1;
       int j=1;
       int count=0;
       if(name.charAt(0)==typed.charAt(0)) {
        while(i<name.length() && j<typed.length()){
         if(name.charAt(i)==typed.charAt(j)){
            i++;
            j++;
            count++;
         }
         else{
                if(typed.charAt(j)!=name.charAt(i-1)){
                    
                    return false;
                   
                }
                else{
                     j++;}

         }
       } }
       else{
        
        return false;
        
       }
    while(j<typed.length()) {
          if(typed.charAt(j)!= name.charAt(name.length()-1)){
           
        return false;
       }
       j++;
       }
       
       if(count==name.length()-1){
        return true;
       }
        System.out.println(count);
       
       return false;
    }
}