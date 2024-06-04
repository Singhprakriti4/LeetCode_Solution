class Solution {
    public double myPow(double x, int n) {
        long N=n;
        if(N==0){
            return 1;
        }
      double ans;
       if(N<0){
        ans=pow_p(1/x,-N);
       }
       else{
        ans=pow_p(x,N);
       }
      return ans;
    }
    public double pow_p(double x,long n){
        if(n==1){
            return x;
        }
         double a= pow_p(x,n/2);
        if(n%2==0)
       {
        
         return a*a;
         }
         else{
           return a*a*x;
         }
    }
   
}
