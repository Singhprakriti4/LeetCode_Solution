class Solution {
    public int[] closestPrimes(int left, int right) {
      ArrayList<Integer> primes=new ArrayList<>();
      for(int i=left;i<=right;i++){
        if(i==2 || isPrime(i)){
          primes.add(i);  
          break;
        }
      }  
      if(primes.size()==0){
        return new int[]{-1,-1};
      }
      
      int i=primes.get(0);
      while(i<=right){
        if(i==2){
            primes.add(3);
            i=3;
        }
        else if(i!=primes.get(0) && isPrime(i)){
            primes.add(i);
        }
        i+=2;
      }
      if(primes.size()==1){
        return new int[]{-1,-1};
      }
      System.out.println(primes);
      int a=primes.get(0);
      int b=primes.get(1);

      int mindist=b-a;

      for(int j=1;j<primes.size()-1;j++){
        if(primes.get(j+1)-primes.get(j)<mindist){
            mindist=primes.get(j+1)-primes.get(j);
            a=primes.get(j);
            b=primes.get(j+1);
        }
      }
      return new int[]{a,b};
    }

    public boolean isPrime(int num){
       //check divisibility with odd numbers

      if(num==2 || num==3 || num==5){
        return true;
       }
       if(num%2==0 || num==1){
        return false;
       }
       int i=3;
       while(i<=Math.sqrt(num)){
        if(num%i==0){
            return false;
        }
        i+=2;
       }
        return true; 
    }
}