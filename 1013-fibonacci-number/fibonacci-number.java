class Solution {
    // //recursive 
    // public int fib(int n) {
    //    if(n==0 || n==1){
    //     return n;
    //    } 
    //    return fib(n-1)+fib(n-2);
    // }

    // iterative

    // public int fib(int n){
    //     int ans=0;
    //  int a=0;
    //  int b=1;

    //  if(n==0){
    //     return a;
    //  }
    //  if(n==1){
    //     return b;
    //  }
    //  for(int i=2;i<=n;i++){
    //     ans=a+b;
    //     a=b;
    //     b=ans;
    //  }

    //  return ans;
    // }

    //dynamic programming

    //1. memoization
    Map<Integer,Integer> m=new HashMap<>();
    public int fib(int n){
        if(n==0 || n==1){
        return n;
       } 
      if(m.containsKey(n)){
        return m.get(n);
      }

      int ans=fib(n-1)+fib(n-2);
      m.put(n,ans);
      return ans;
    }
    
}