class Solution {
    public void reverseString(char[] s) {
        reverse(s,0,s.length-1);
    }
    public void reverse(char[] s,int st,int e){
        if(st>=e){
            return;
        }
        char temp=s[st];
        s[st]=s[e];
        s[e]=temp;
        reverse(s,st+1,e-1);

    }
}