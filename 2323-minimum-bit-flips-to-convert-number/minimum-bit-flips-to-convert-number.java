class Solution {
    public int minBitFlips(int start, int goal) {
        String a=Integer.toBinaryString(start);
        String b=Integer.toBinaryString(goal);
        int ans=0;
        int index_b=b.length()-1;
        int index_a=a.length()-1;
        while(index_a>=0 && index_b>=0){
            if(a.charAt(index_a)!=b.charAt(index_b)){
                ans++;
            }
            index_a--;
            index_b--;
        }
        
        if(index_b<0 && index_a>=0){
           while(index_a>-1){
            if(a.charAt(index_a)=='1'){
                ans++;
            }
            index_a--;
           }
        }
        else if(index_a<0 && index_b>=0){
           while(index_b>-1){
            if(b.charAt(index_b)=='1'){
                ans++;
            }
            index_b--;
           }
        }
        return ans;
    }
}