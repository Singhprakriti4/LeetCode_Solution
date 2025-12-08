class Solution {

    public int countTriples(int n) {

        int count=0;
        long dob=n*n;

        for(int i=1;i<n;i++){
            if(i*i>dob) break;
            for(int j=i;j<n;j++){

                long x= i*i+j*j;
                int p=(int)Math.sqrt(x);

                if(p*p==x){
                    if(i==j){
                        count+=1;
                    }
                    else{
                        count+=2;
                    }
                }

                if(x>dob){
                    break;
                }
               
            }
        }
        return count;
    }
}