class Solution {
    public void reverseString(char[] s) {

    char temp;
    for(int i=0;i<s.length/2;i++){
        temp=s[i];
        s[i]=s[s.length-1-i];
        s[s.length-1-i]=temp;
    }
    //     reverse(s,0,s.length-1);
    // }
    // public void reverse(char[] s,int st,int e){
    //     if(st>=e){
    //         return;
    //     }
    //     char temp=s[st];
    //     s[st]=s[e];
    //     s[e]=temp;
    //     reverse(s,st+1,e-1);

    }
}