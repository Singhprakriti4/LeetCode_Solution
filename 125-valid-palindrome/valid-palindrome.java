class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder answer=new StringBuilder();
        int k=0,l=0,m=0;
     for(int i=0;i<s.length();i++){
        k=s.charAt(i)-'a';
        l=s.charAt(i)-'A';
        m=s.charAt(i)-'0';
       if((k<26 && k>=0) ){
        answer.append(s.charAt(i));
       }
       else if(l<26 && l>=0){
        answer.append((char)( s.charAt(i)+32));
       }
       else if(m<10  && m>=0){
        answer.append(s.charAt(i));
       }
     }
      String line=answer.toString();
      System.out.println(line);
      answer.reverse();
      String reversed=answer.toString();
        System.out.println(reversed);
      if(line.equals(reversed)){
        return true;
      }
       return false;
    }
}