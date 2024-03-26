class Solution {
    public int strStr(String haystack, String needle) {
       
        int i=0;
        while(i<haystack.length()){
            if(haystack.charAt(i)==needle.charAt(0)){
                int count=0;
                int ans=i;
                for(int j=0;j<needle.length();j++){
                   if ( i<haystack.length() && haystack.charAt(i)==needle.charAt(j)){
                    i++;
                    count++;
                   }
                   else{
                    break;
                   }
                }
                //iterate for equality //if true retun i//else move ahead
                if(count==needle.length()){
                    return ans;
                }
                else{
                    i=ans+1;
                }
            }
            else{
                i++;
            }
        }
       return -1;

    }


}