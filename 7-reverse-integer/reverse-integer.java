class Solution {
    public int reverse(int x) {
        if(x==0){
            return 0;
        }
        int ans=x%10;
        x=x/10;
        while(x!=0){
             if(Math.abs(ans)>Integer.MAX_VALUE/10){
                return 0;
            }
            ans=ans*10+x%10;
            x=x/10;
        }
       
        return ans;
    }
}