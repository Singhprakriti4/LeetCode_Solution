class Solution {
    public int maxOperations(String s) {

        int count=0;
        int noofones=(s.charAt(0)=='1')?1:0;

        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='1'){
                if(s.charAt(i-1)=='0'){
                    // System.out.println("hi");
                    count+=noofones;
                }
                noofones+=1;
            }
            else if(i==s.length()-1){
                count+=noofones;
            }
        }
        return count;
    }
}