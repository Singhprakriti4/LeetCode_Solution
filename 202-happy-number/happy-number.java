class Solution {
    public boolean isHappy(int n) {
        int s=1,f=0;
        int j=n;
        while(s!=f){
           s=nextvalue(n);
            if(s==1){
                return true;
            }
           n=s;
            f=nextvalue(nextvalue(j));
            if(f==1){
                return true;
            }
           j=f;
        }
 return false;
        
    }
    public int nextvalue(int n){
        int sum=0;
        while(n>0){
         sum+=Math.pow(n%10,2);
         n=n/10;
    }
    return sum;
    }
}