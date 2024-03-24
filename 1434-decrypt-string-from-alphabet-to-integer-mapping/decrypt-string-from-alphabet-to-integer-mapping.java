class Solution {
    public String freqAlphabets(String s) {
        char arr[]=s.toCharArray();
        int k=0, num=0,i=arr.length-1;
        StringBuilder result=new StringBuilder();
        while(i>=0){
            if(arr[i]!='#'){
               k=arr[i]-'0'-1;
               result.append((char)('a'+k));
               i--;
            }
            else if(arr[i]=='#'){
                 num=(arr[i-2]-'0')*10 +(arr[i-1]-'0');
                k=num-10;
                result.append((char)('j'+k));
                i=i-3;
            }
        }
        result.reverse();
        String ans=result.toString();

        return ans;
    }
}