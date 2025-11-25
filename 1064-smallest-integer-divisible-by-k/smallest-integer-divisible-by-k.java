class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k==1) return 1;
        if(k%2==0 || k%5==0){
            return -1;
        }
        long num=1;
        num=num%k;
        int l=1;
        while(num<Long.MAX_VALUE){
           if(num==0){
            return l;
           }
           l=l+1;
           num=(num*10+1)%k;
        }
        return -1;
    }
}