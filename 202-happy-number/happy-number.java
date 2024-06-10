class Solution {
    public boolean isHappy(int n) {
        int s=1,f=0, j=n;;
        while(s!=f){
           
            
           s=nextvalue(n);
            n=s;   
              if(s==1){
                return true;
            }    
           
            f=nextvalue(nextvalue(j));
             j=f;
               if(f==1){
                return true;
            }
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