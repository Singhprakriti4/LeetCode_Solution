class Solution {
    public String lastSubstring(String s) {

      int Indexmax=s.length()-1;

      for(int Indexcurr=s.length()-1;Indexcurr>=0;Indexcurr--){
         if(s.charAt(Indexcurr)>s.charAt(Indexmax)){
            Indexmax=Indexcurr;
         }
         else if(s.charAt(Indexcurr)==s.charAt(Indexmax)){
            int i=Indexcurr+1;
            int j=Indexmax+1;
            while(i<Indexmax && j<s.length() &&  s.charAt(i)==s.charAt(j)){
                i++;
                j++;
            }
            if(i==Indexmax || j==s.length() || s.charAt(i)>s.charAt(j)){
                Indexmax=Indexcurr;
            }
         }
      }
       return s.substring(Indexmax);

    }
}