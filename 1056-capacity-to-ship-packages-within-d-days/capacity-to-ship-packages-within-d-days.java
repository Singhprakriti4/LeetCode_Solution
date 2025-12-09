class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s=1;
        int e=Integer.MAX_VALUE;
        int ans=0;
        while(s<=e){

            int m=s+(e-s)/2;
            if(valid(m,weights,days)){
                ans=m;
                e=m-1;
            }
            else{
                s=m+1;
            }
        }
        return ans;
    }
    public boolean valid(int d, int[] w, int days){
        int test=0;
        int sum=0;
        for(int i=0;i<w.length;i++){
         if(w[i]>d) return false;
         sum+=w[i];
         if(sum>d){
            test+=1;
            sum=w[i];
         }
        }
        test+=1;       
        return test<=days;
    }
}