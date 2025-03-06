class Solution {
    public int reverse(int x) {
        if(x==0){
            return 0;
        }
        long ans=x%10;
        x=x/10;
        while(x!=0){
            ans=ans*10+x%10;
            x=x/10;
        }
        if(Math.abs(ans)>(long)Integer.MAX_VALUE){
            return 0;
        }
        return (int)ans;
    }
}