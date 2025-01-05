/*
the idea is t
 */
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
      int[] shift_arr=new int[s.length()];

      for(int i=0;i<shifts.length;i++){
        int start=shifts[i][0];
        int end=shifts[i][1];
        if(shifts[i][2]==1){
            shift_arr[start]+=1;
            if(end<s.length()-1){
                shift_arr[end+1]-=1;
            }
        }
        else{
            shift_arr[start]-=1;
            if(end<s.length()-1){
                shift_arr[end+1]+=1;
            }
        }
      }
      StringBuilder str=new StringBuilder();
      int inc=0;

    for(int i=0;i<s.length();i++){
        inc+=shift_arr[i];
         str.append((char)('a'+((s.charAt(i)-'a' +inc +26)%26+26)%26));
      }

     return str.toString();
    }
}