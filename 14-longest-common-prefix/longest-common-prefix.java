class Solution {
    public String longestCommonPrefix(String[] arr) {
        StringBuilder prefix=new StringBuilder();
        String ans=arr[0];
        String test=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=test){
                int len=findindex(arr[i],test);
                ans=test.substring(0,len+1);
                test=ans;
            }
        }
        return ans;
    }
    public int findindex(String src,String test){
       int len=-1;
        for(int i=0;i<src.length();i++){
            if(i<test.length()){
                if(src.charAt(i)==test.charAt(i)){
                    len++;
                }
                else{
                    break;
                }
            }
            else{
                break;
            }
        }
        return len;
    }
}